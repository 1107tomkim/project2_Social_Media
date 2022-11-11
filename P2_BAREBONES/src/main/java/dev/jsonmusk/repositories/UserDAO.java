package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.User;

import java.util.List;


public interface UserDAO {

    //CREATE
    User createUser(User user);
    //READ
    User getUserById(int id);
    User getUserByUsername(String username);

    //UPDATE
    User updateUser(User user);

    User updateUserLogin(User user);

    void logout();

    //DELETE



}
