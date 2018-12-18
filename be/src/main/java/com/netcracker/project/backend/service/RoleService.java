package com.netcracker.project.backend.service;

import com.netcracker.project.backend.entity.Role;
import java.util.Optional;

public interface RoleService {
    Role saveRole (Role role);
    Optional<Role> getRole(Integer id);
    Iterable<Role> getAllRls();
}
