package dev.jsonmusk.services;

import dev.jsonmusk.entities.AuthRequest;
import dev.jsonmusk.entities.AuthResponse;

public interface User2Service {
    AuthResponse signup (AuthRequest request);
    AuthResponse login (AuthRequest request);
    boolean authorize (String token, String userId);
}
