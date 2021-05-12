package ru.mojjjiiia.rentech.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.mojjjiiia.rentech.model.User;
import ru.mojjjiiia.rentech.security.jwt.JwtUser;
import ru.mojjjiiia.rentech.security.jwt.JwtUserFactory;
import ru.mojjjiiia.rentech.service.UserService;

@Service
@Slf4j
public class JwtUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public JwtUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user with username: " + username + " not found!");
        }

        JwtUser jwtUser = JwtUserFactory.create(user);
        log.info("In loadUserByUsername - jwt user with username {} successfully loaded", jwtUser.getUsername());

        return jwtUser;
    }
}
