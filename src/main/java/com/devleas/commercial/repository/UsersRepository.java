package com.devleas.commercial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devleas.commercial.domain.User;

public interface UsersRepository extends JpaRepository<User, Long>{
	
	User findByUserName(String user);
	
}
