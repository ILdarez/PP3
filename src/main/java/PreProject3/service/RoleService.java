package PreProject3.service;

import PreProject3.model.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findByName(String name);
}
