package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.User;

import java.util.List;


public interface UserDAO {

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
