package dev.jsonmusk.managers;

public interface TokenManager {

    String issueToken (String userId);

    boolean authorize (String token, String userId);

}