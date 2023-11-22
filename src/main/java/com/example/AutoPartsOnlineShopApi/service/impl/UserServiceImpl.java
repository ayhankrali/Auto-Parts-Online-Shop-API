package com.example.AutoPartsOnlineShopApi.service.impl;

import com.example.AutoPartsOnlineShopApi.entity.User;
import com.example.AutoPartsOnlineShopApi.repository.UserRepository;
import com.example.AutoPartsOnlineShopApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);

    }

    @Override
    public void createUser(String username, String password) {
        // Check if the username is already taken
        if (userRepository.existsByUsername(username)) {
            // Handle the case where the username is already taken
            return;
        }

        // Create a new user
        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));

        // Save the user to the database
        userRepository.save(newUser);

    }

}
