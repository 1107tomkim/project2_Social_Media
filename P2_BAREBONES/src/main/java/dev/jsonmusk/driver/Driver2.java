package dev.jsonmusk.driver;

import dev.jsonmusk.controllers.CommentController;
import dev.jsonmusk.controllers.PostController;
import dev.jsonmusk.controllers.UserController;
import dev.jsonmusk.controllers.UserController2;
import dev.jsonmusk.managers.JjwtTokenManagerImpl;
import dev.jsonmusk.managers.TokenManager;
import dev.jsonmusk.repositories.*;
import dev.jsonmusk.services.*;
import io.javalin.Javalin;

public class Driver2 {

    public static void main(String[] args) throws Exception{
        TokenManager manager = new JjwtTokenManagerImpl();

        User2Repository userRepository = new User2RepositoryImpl();
        User2Service userService = new User2ServiceImpl(userRepository, manager);
        UserController2 userController = new UserController2(userService);

        Javalin app = Javalin.create().start(4000);


//        app.before("/protected/*", userController::authorize);
//
//        app.post("/protected/tasks", taskController::create);
//        app.put("/protected/tasks/:id/finish", taskController::markFinished);
//        app.delete("/protected/tasks/:id", taskController::remove);
//        app.get("/protected/tasks/:userId", taskController::findAll);

        app.post("/signup", userController::signup);
        app.post("/login", userController::login);
    }
}