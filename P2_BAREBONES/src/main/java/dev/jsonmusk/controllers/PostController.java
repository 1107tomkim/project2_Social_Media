package dev.jsonmusk.controllers;

import com.google.gson.Gson;
import dev.jsonmusk.driver.Driver;
import dev.jsonmusk.entities.Post;
import io.javalin.http.Handler;

import java.util.List;

public class PostController {


    public Handler createPostHandler = (ctx) -> {
        String json = ctx.body();
        Gson gson = new Gson();
        Post newPost = gson.fromJson(json, Post.class);
        Post createdPost = Driver.postService.createPost(newPost);
    };

    public Handler getPostbyIdHandler = (ctx) -> {
        int id = Integer.parseInt(ctx.pathParam("post_id"));
//        String json = ctx.body();
//        Gson gson = new Gson();
//        Post newPost = gson.fromJson(json, Post.class);
        Post gottenPost = Driver.postService.getPostById(id);

    };

    public Handler getFeedHandler = (ctx) -> {
      // Will return all the posts in Chronological order
        List<Post> feed = Driver.postService.getFeed();
        Gson gson =  new Gson();
        ctx.result(gson.toJson(feed, Post.class));
    };

}
