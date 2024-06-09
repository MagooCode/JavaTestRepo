package com.spring.taskmanagement.service;

import com.spring.taskmanagement.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();
    public User getUserById(long id);
    public String createUser(User user);
    public String updateUser(long id, User userToUpdate);
    public String deleteUserById(long id);
}