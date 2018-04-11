package br.com.udemy.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.udemy.api.entity.User;


public interface UserRepository extends MongoRepository<User, String>{
    public User findByEmail(String email);
    
}