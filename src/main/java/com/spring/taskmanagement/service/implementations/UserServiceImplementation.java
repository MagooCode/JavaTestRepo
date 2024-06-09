package com.spring.taskmanagement.service.implementations;

import com.spring.taskmanagement.entity.User;
import com.spring.taskmanagement.repository.UserRepository;
import com.spring.taskmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String createUser(User user) {
        userRepository.save(user);
        return "User successfully created";
    }

    @Override
    public String updateUser(long id, User userToUpdate) {
        User existingUser = userRepository.findById(id).orElse(null);
        if (existingUser != null) {
            existingUser.setUsername(userToUpdate.getUsername());
            userRepository.save(existingUser);
            return "User successfully updated";
        }
        return null;
    }

    @Override
    public String deleteUserById(long id) {
        userRepository.deleteById(id);
        return "User successfully deleted";
    }
}
