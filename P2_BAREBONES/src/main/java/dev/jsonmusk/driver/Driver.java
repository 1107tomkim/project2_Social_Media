package dev.jsonmusk.driver;

import dev.jsonmusk.controllers.PostController;
import dev.jsonmusk.controllers.UserController;
import dev.jsonmusk.repositories.PostDAOPostgres;
import dev.jsonmusk.services.PostService;
import dev.jsonmusk.services.PostServiceImpl;
import io.javalin.Javalin;
import dev.jsonmusk.repositories.UserDAOPostgres;
import dev.jsonmusk.services.UserService;
import dev.jsonmusk.services.UserServiceImplementation;

public class Driver {
    public static UserService userService = new UserServiceImplementation(new UserDAOPostgres());

    public static PostService postService = new PostServiceImpl(new PostDAOPostgres());

    public static void main(String[] args) {



        Javalin app = Javalin.create(

                javalinConfig -> {
                    javalinConfig.enableCorsForAllOrigins();
                }


        );


        UserController userController = new UserController();
        PostController postController = new PostController();
        // put app.get, etc. (routes) here

        // go
        app.start();




    }
}