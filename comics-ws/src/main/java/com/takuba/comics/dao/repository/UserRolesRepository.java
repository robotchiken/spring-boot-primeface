package com.takuba.comics.dao.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.takuba.comics.dao.model.UserRole;

public interface UserRolesRepository extends JpaRepository<UserRole, Integer> {
	List<UserRole>findByUsername(String username);
}
