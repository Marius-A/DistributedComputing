package com.mariusiliescu.cloudcomputing.service;

import com.mariusiliescu.cloudcomputing.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User findByEmail(String email);
}
