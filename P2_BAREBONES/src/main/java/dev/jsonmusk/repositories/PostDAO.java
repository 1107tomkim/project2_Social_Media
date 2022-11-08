package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.Post;

import java.util.List;

public interface PostDAO {

    //CREATE
    Post createPost(Post post);
    //READ
    Post getPostById(int id);

    //UPDATE
    Post updatePost(Post post);

    //DELETE

    boolean deletePostById(int id);



}
