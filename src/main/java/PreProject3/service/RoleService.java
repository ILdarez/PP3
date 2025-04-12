package PreProject3.service;

import PreProject3.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Set<Role> getRolesByNames(Set<String> roleNames);

    List<Role> getAllRoles();

    Role findByName(String name);

    void save(Role role);
}
