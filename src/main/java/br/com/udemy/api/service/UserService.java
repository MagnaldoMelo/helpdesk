package br.com.udemy.api.service;

import java.util.List;

import org.springframework.data.domain.Page;

import br.com.udemy.api.entity.User;

public interface UserService{
    public User findByEmail(String email);
    public User createOrUpdate(User user);
    public User findById(String id);
    public void delete(String id);
    public Page<User> findAll(Integer page, Integer count);
    public List<User> findTudo();
}