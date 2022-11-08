package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.User;
import dev.jsonmusk.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOPostgres implements UserDAO {

    @Override
    public User createUser(User user) {
        // insert user into DB
        return null;
    }

    @Override
    public User getUserById(int id) {
        // get the user by the id parameter
        return null;
    }

    @Override
    public User updateUser(User user) {
        // take the user in parameter and update the corresponding user(id) in db
        return null;
    }

    @Override
    public void login() {
        //log in
    }

    @Override
    public void logout() {
        //log out
    }
}