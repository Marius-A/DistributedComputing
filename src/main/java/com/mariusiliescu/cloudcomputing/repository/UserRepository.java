package com.mariusiliescu.cloudcomputing.repository;

import com.mariusiliescu.cloudcomputing.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByEmail(String email);
}
