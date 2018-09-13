package com.takuba.comics.dao.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takuba.comics.dao.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	User findByUsername(String username);
}
