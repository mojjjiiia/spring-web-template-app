package ru.mojjjiiia.rentech.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ru.mojjjiiia.rentech.model.Role;
import ru.mojjjiiia.rentech.model.User;
import ru.mojjjiiia.rentech.repository.RoleRepository;
import ru.mojjjiiia.rentech.repository.UserRepository;
import ru.mojjjiiia.rentech.service.UserService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("ROLE_USER");

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Collections.singletonList(roleUser));

        User registeredUser = userRepository.save(user);

        log.info("In register - user: {} successfully registered", registeredUser);
        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> users = userRepository.findAll();
        log.info("In getAll - returned {} users", users.size());
        return users;
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        log.info("In findByUsername - {} was found", user.getUsername());
        return user;
    }

    @Override
    public User findById(Long id) {
        User user = userRepository.findById(id).orElseThrow();
        log.info("In findByUsername - {} was found", user);
        return user;
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
        log.info("In delete - user with id {} was deleted", id);

    }
}
