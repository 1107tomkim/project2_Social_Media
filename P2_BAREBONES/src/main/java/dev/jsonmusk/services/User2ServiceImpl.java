package dev.jsonmusk.services;

import dev.jsonmusk.entities.AuthRequest;
import dev.jsonmusk.entities.AuthResponse;
import dev.jsonmusk.entities.User2;
import dev.jsonmusk.managers.TokenManager;
import dev.jsonmusk.repositories.User2Repository;
import io.javalin.http.ForbiddenResponse;

import java.util.Optional;

public class User2ServiceImpl implements User2Service{

    private User2Repository repository;
    private TokenManager manager;

    public User2ServiceImpl(User2Repository repository, TokenManager manager) {
        this.repository = repository;
        this.manager = manager;
    }


    @Override
    public AuthResponse signup(AuthRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        User2 user = repository.signup(email, password);
        String userId = user.getUserId();
        String token = manager.issueToken(userId);
        AuthResponse response = new AuthResponse(userId, token);
        return response;
    }

    @Override
    public AuthResponse login(AuthRequest request) {
        String email = request.getEmail();
        String password = request.getPassword();
        Optional<User2> result = repository.findByEmail(email);
        if (result.isPresent()){
            User2 user = result.get();
            String passwordInDatabase = user.getPassword();
            if (password.equalsIgnoreCase(passwordInDatabase)) {
                String userId = user.getUserId();
                String token = manager.issueToken(userId);
                AuthResponse response = new AuthResponse(userId, token);
                return response;
            } else {
                throw new ForbiddenResponse();
            }
        } else {
            throw new ForbiddenResponse();
        }
    }

    @Override
    public boolean authorize(String token, String userId) {
        boolean result = manager.authorize(token, userId);
        return result;
    }
}
