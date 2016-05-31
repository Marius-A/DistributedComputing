package com.mariusiliescu.cloudcomputing.service;

import com.mariusiliescu.cloudcomputing.model.User;
import com.mariusiliescu.cloudcomputing.repository.RoleRepository;
import com.mariusiliescu.cloudcomputing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public long save(User user) {
        long id=0;
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        User u = userRepository.save(user);
        id = u.getId();
        return id;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
