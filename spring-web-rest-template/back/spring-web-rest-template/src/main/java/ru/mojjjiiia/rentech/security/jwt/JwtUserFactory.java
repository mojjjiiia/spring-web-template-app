package ru.mojjjiiia.rentech.security.jwt;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import ru.mojjjiiia.rentech.model.Role;
import ru.mojjjiiia.rentech.model.Status;
import ru.mojjjiiia.rentech.model.User;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public final class JwtUserFactory {
    public static JwtUser create(User user) {
        return new JwtUser(
          user.getId(),
          user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getMiddleName(),
                user.getPassword(),
                user.getEmail(),
                user.getUpdatedAt(),
                user.getStatus().equals(Status.ACTIVE),
                mapToGrantedAuthorities(user.getRoles())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> userRoles) {
        return userRoles.stream()
                .map(
                        role -> new SimpleGrantedAuthority(role.getName())
                )
                .collect(Collectors.toList());
    }
}
