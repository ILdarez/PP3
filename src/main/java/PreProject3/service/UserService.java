package PreProject3.service;


import PreProject3.model.Role;
import PreProject3.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> findByUsername(String username);

    Optional<User> getUserById(Long id);

    List<User> getAllUsers();

    List<Role> getAllRoles();

    void createUser(User user, List<Long> roleIds);

    void updateUser(Long id, String firstName, String lastName, Integer age, String email, List<Long> roleIds, String password);

    void deleteUser(Long id);
}
