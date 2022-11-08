package dev.jsonmusk.services;

import dev.jsonmusk.entities.User;

import java.util.List;


public interface UserService {

    //CREATE
    User createUser(User user);
    //READ
    User getUserById(int id);

    //UPDATE
    User updateUser(User user);

    void login();

    void logout();

    //DELETE


}
