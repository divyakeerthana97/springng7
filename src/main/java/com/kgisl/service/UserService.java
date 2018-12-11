package com.kgisl.service;

import java.util.List;
import java.util.Optional;

import com.kgisl.entity.User;



public interface UserService {

    public User createUser(User user);
    public List<User> getUsers();
    public User findByUserId(Long id);
    public User updateUser(Long id,User user);
    public void deleteUserById(Long id); 

}
