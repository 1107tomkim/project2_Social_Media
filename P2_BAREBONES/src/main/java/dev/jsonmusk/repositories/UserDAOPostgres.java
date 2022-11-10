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
    public User getUserByUsername(String username) {
        System.out.println("userdao: getUserByUsername");
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "select * from users where username=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();

            User gottenUser = new User();
            gottenUser.setId(rs.getInt("user_id"));
            gottenUser.setUsername(rs.getString("username"));
            gottenUser.setPassword(rs.getString("passwd"));
            gottenUser.setFirstname(rs.getString("fname"));
            gottenUser.setLastname(rs.getString("lname"));
            gottenUser.setEmail(rs.getString("email"));
            gottenUser.setLoggedIn(rs.getBoolean("isLogged"));
            System.out.println(gottenUser);
            return gottenUser;

        } catch (SQLException e) {
            e.printStackTrace();
        }

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