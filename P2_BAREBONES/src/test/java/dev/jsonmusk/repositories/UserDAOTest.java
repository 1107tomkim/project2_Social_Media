package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDAOTest {

    // FORMAT REFERENCE
//    static PostDAO postDAO = new PostDAOPostgres();
//
//    @Test
//    @Order(1)
//    void create_request_test() {
////        Post newRequest = new Post(0, 1, 250.00f, "chairs", Post.Type.OTHER);
////        Post savedRequest = postDAO.createReimbursementRequest(newRequest);
////        System.out.println(savedRequest);
////        Assertions.assertNotNull(savedRequest);
////        Assertions.assertEquals("chairs", savedRequest.getDescription());
//    }

    static UserDAO userDAO = new UserDAOPostgres();

    @Test
    void createUser() {
        User testuser = new User(0, "testdood", "password", false);
        User savedUser = userDAO.createUser(testuser);
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals(testuser.getUsername(), savedUser.getUsername());
    }

    @Test
    void getUserById() {
    }

    @Test
    void getUserByUsername() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void updateUserLogin() {
    }

    @Test
    void logout() {
    }

}