package dev.jsonmusk.repositories;

import dev.jsonmusk.entities.User2;

import java.util.Optional;

public interface User2Repository {

    User2 signup (String email, String password);

    Optional<User2> findByEmail (String email);

}

