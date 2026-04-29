package com.example.task3.service;

import com.example.task3.model.User;
import com.example.task3.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    /*
    @PostConstruct
    public void run(){
        addUser(new User("Ваня", "pochta.ru"));
        addUser(new User("степа", "gmail.com"));
        getAllUsers().forEach(System.out::println);
    }
    */


    public User createUser(User user) {
        user.setDateAdded(LocalDateTime.now());
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }


    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id);
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


    @Deprecated
    public void addUser(User user) {
        createUser(user);
    }
}