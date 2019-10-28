package com.devleas.commercial.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devleas.commercial.domain.User;
import com.devleas.commercial.repository.UsersRepository;

@Service
public class UsersService {

	@Autowired
	private UsersRepository usersRepository;
	
	public User salvar(User user) {
		return usersRepository.save(user);
	}
	
	public List<User> listar() {
		return usersRepository.findAll();
	}
	
	public User buscarPorId(Long id) {
		User user = usersRepository.getOne(id);
		return user;
	}
	
	public User buscarPorUserName(String userName) {
		return usersRepository.findByUserName(userName);
	}
	
}
