package dev.jsonmusk.services;

import dev.jsonmusk.driver.Driver;
import dev.jsonmusk.entities.User;
import dev.jsonmusk.repositories.UserDAO;

import java.util.List;


public class UserServiceImplementation implements UserService {

    private UserDAO userDAO;
    public UserServiceImplementation(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    public User createUser(User user) {
        return this.userDAO.createUser(user);
    }

    @Override
    public User getUserById(int id) {
        return this.userDAO.getUserById(id);
    }

    @Override
    public User updateUser(User user) {
        return this.userDAO.updateUser(user);
    }

    @Override
    public void login() {

    }

    @Override
    public void logout() {

    }
}
