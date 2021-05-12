package ru.mojjjiiia.rentech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mojjjiiia.rentech.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
