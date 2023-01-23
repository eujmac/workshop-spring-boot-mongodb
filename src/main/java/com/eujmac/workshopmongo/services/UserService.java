package com.eujmac.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eujmac.workshopmongo.domain.User;
import com.eujmac.workshopmongo.dto.UserDTO;
import com.eujmac.workshopmongo.repository.UserRepository;
import com.eujmac.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repo;
	
	public List<User> findAll(){
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public User fromDTO(UserDTO usDto) {
		return new User(usDto.getId(), usDto.getName(), usDto.getEmail());
	}
}
