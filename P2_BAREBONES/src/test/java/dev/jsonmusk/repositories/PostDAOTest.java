package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostDAOTest {

    static PostDAO postDAO = new PostDAOPostgres();

    @Test
    void createPost() {
        Post newPost = new Post();
        Post savedPost = postDAO.createPost(newPost);
        Assertions.assertNotNull(savedPost);
    }

    @Test
    void getPostById() {
    }

    @Test
    void updatePost() {
    }

    @Test
    void deletePostById() {
    }
}