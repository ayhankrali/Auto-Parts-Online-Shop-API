package com.example.AutoPartsOnlineShopApi.service.user;

import com.example.AutoPartsOnlineShopApi.entity.user.User;

import java.util.Optional;

public interface UserService {

    User save(User user);

    Optional<User> findByUsername(String username);

    void createUser(String username, String password);
}
