package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.User;
import dev.jsonmusk.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOPostgres implements UserDAO {

    @Override
    public User createUser(User user) {
        try (Connection connection = ConnectionFactory.getConnection()){
            //INSERT INTO users VALUES (DEFAULT, 'User1', 'password', 'George', 'Neilson', 'georgeyboy@office.net', FALSE);
            String sql = "insert into usertest values(default, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());
            ps.setString(5, user.getEmail());
            ps.setBoolean(6, user.isLoggedIn());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            int generatedKey = rs.getInt("user_id");
            user.setId(generatedKey);
            return user;

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
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
            String sql = "select * from usertest where username=?";
            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            rs.next();

            User gottenUser = new User();
            gottenUser.setId(rs.getInt("user_id"));
            gottenUser.setUsername(rs.getString("username"));
            gottenUser.setPassword(rs.getString("password"));
            gottenUser.setFirstname(rs.getString("firstname"));
            gottenUser.setLastname(rs.getString("lastname"));
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