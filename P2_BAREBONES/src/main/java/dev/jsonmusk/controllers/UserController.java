package dev.jsonmusk.controllers;

import com.google.gson.Gson;
import dev.jsonmusk.driver.Driver;
import dev.jsonmusk.entities.User;
import io.javalin.http.Context;
import io.javalin.http.Handler;

public class UserController {

    public Handler loginHandler = (ctx) -> {

        String json = ctx.body();
        Gson gson = new Gson();
        User user = gson.fromJson(json, User.class);

        int returnval = Driver.userService.login(user.getUsername(), user.getPassword());
        if (returnval == 2) {
            ctx.status(200);
            ctx.result("something is good " + returnval);
        }
        else if (returnval == 1) {
            ctx.status(401);
            ctx.result("something is bad " + returnval);
        } else
            ctx.status(400);
            ctx.result("something is bad " + returnval);

    };

}
