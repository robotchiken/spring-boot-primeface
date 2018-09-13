package com.takuba.comics.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.takuba.comics.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private AuthenticationEntryPoint authEntryPoint;
	@Autowired
	private DataSource dataSource;
	@Autowired
	private PasswordEncoder bCryptPasswordEncoder;
	@Value("${spring.queries.users-query}")
	private String usersQuery;
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	@Autowired 
	UserDetailsServiceImpl userDetailService;
	@Autowired
    private AccessDeniedHandler accessDeniedHandler;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		http.csrf().disable().authorizeRequests()
				.anyRequest().authenticated()
				.and().httpBasic()
				.authenticationEntryPoint(authEntryPoint);
				*/
		/*
		http.csrf().disable().httpBasic().and()
		  .authorizeRequests()
		.antMatchers(HttpMethod.GET, "/buscarComic").hasAuthority("ADMIN")//Se debe de tener este rol en especifico para poder hacer la peticion
		.antMatchers(HttpMethod.GET,"/listarComics").hasAnyAuthority("USER,ADMIN").
		antMatchers(HttpMethod.POST,"/insertarComic").hasAuthority("ADMIN").
		antMatchers(HttpMethod.GET,"/listarEditoriales").hasAnyAuthority("ADMIN").
		antMatchers(HttpMethod.GET,"/listarPeriodicidad").hasAnyAuthority("ADMIN");//Se puede tener cualquiera de estos roles para poder hacer la peticion
		*/
		http.authorizeRequests().and().exceptionHandling().accessDeniedHandler(accessDeniedHandler);
		http.authorizeRequests().antMatchers("/welcome").hasAnyAuthority("ADMIN","USER");
		http.authorizeRequests().
		and().formLogin()
         .loginPage("/login")
         .failureUrl("/login?error=true")
         .defaultSuccessUrl("/welcome")
         .usernameParameter("username")//
         .passwordParameter("password").and().logout().permitAll();
         
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		//auth.inMemoryAuthentication().withUser("john123").password("{noop}password").roles("USER");
		//auth.jdbcAuthentication().usersByUsernameQuery(usersQuery).authoritiesByUsernameQuery(rolesQuery).dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder);
		auth.userDetailsService(userDetailService).passwordEncoder(bCryptPasswordEncoder);
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
}
