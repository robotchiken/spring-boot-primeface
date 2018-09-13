package com.takuba.comics.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.takuba.comics.dao.repository.ComicRepository;
import com.takuba.comics.dao.repository.EditorialRepository;
import com.takuba.comics.dao.repository.PeriodicidadRepository;

@Controller
public class ComicsController {
	@Autowired
	ComicRepository comicRepository;
	@Autowired 
	EditorialRepository editorialRepository;
	
	@Autowired
	PeriodicidadRepository periodRepository;
	
	@RequestMapping("/")
	public String welcome(Map<String, Object> model) {
		
		return "login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	 public String login(Model model, String error, String logout) {
		String pagina="welcome";
		if (error.equals("true")){
			 model.addAttribute("error", "Your username and password is invalid.");
			 pagina="login";
		}else{
			 model.addAttribute("message","Hola Mundo desde Spring Boot");
		}
		if (logout != null){
		 model.addAttribute("message", "You have been logged out successfully.");
		}
	
	 return pagina;
	 }
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	 public String welcome(Model model, Authentication authentication) {
		String pagina="welcome";
		if(authentication.getAuthorities().size() ==1){
			for(GrantedAuthority aut: authentication.getAuthorities()){
				aut.getAuthority();
				if(aut.getAuthority().equals("USER")){
					pagina="user";
				}
			}
		}else{
			model.addAttribute("listaComics", comicRepository.findAll()) ;
			model.addAttribute("listaEditoriales", editorialRepository.findAll());
			model.addAttribute("listaPerio", periodRepository.findAll());
		}
		model.addAttribute("message","Hola Mundo desde Spring Boot "+((User)authentication.getPrincipal()).getUsername());
	 return pagina;
	 }
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	 public String user(Model model, Authentication authentication) {
		String pagina="user";
		model.addAttribute("message","Hola Mundo desde Spring Boot "+((User)authentication.getPrincipal()).getUsername());
	 return pagina;
	 }
	
	@GetMapping("/403")
    public String error403() {
        return "403";
    }
}
