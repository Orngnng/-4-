package com.example.task3.service;

import com.example.task3.model.User;
import com.example.task3.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void demonstrateCrud() {
        System.out.println("CRUD");

        // 1. Создание (CREATE)
        System.out.println("\n1. Создание пользователей:");
        userRepository.save(new User("Иван", "ivan2222@mail.ru"));
        userRepository.save(new User("Мария", "maria22222@gmail.com"));


        System.out.println("чуваки");
        List<User> allUsers = userRepository.findAll();
        allUsers.forEach(System.out::println);


        System.out.println("\nпоиск чуваков");
        Optional<User> userOpt = userRepository.findById(1L);
        userOpt.ifPresent(System.out::println);


        System.out.println("\nобновление чуваков с ID 1:");
        if (userOpt.isPresent()) {
            User userToUpdate = userOpt.get();
            userToUpdate.setName("Иван Обновленный");
            userToUpdate.setEmail("new.ivan@mail.ru");
            userRepository.save(userToUpdate);
            System.out.println("Результат " + userRepository.findById(1L).orElse(null));
        }


        System.out.println("\n5. Удаление  с ID 2:");
        userRepository.deleteById(2L);
        System.out.println("Оставшиеся");
        userRepository.findAll().forEach(System.out::println);


    }
}