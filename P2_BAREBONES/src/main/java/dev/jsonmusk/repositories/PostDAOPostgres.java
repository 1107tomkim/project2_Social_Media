package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.Comment;
import dev.jsonmusk.entities.Post;
import dev.jsonmusk.util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAOPostgres implements PostDAO {

    @Override
    public Post createPost(Post post) {
        // insert this new post into db
        return null;
    }

    @Override
    public Post getPostById(int id) {
        // select the post from db with corresponding id
        return null;
    }



    @Override
    public Post updatePost(Post post) {
        // update the post in db with corresponding id
        return null;
    }

    @Override
    public boolean deletePostById(int id) {
        // delete post from db
        return false;
    }
}
