package dev.jsonmusk.controllers;

import com.google.gson.Gson;
import dev.jsonmusk.driver.Driver;
import dev.jsonmusk.entities.Post;
import io.javalin.http.Handler;

public class PostController {


    public Handler createPostHandler = (ctx) -> {
        String json = ctx.body();
        Gson gson = new Gson();
        Post newPost = gson.fromJson(json, Post.class);
        Post createdPost = Driver.postService.createPost(newPost);
    };
}
