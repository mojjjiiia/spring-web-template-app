package ru.mojjjiiia.rentech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mojjjiiia.rentech.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
