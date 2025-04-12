package PreProject3.service;

import PreProject3.model.Role;
import PreProject3.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Set;

public interface UserService {
    User findByEmail(String email);
    void createUser(User user, Set<String> roles);
    List<User> getAllUsers();
    void updateUser(Long id, User user, Set<String> roles);
    void deleteUser(Long id);

    List<Role>getAllRoles();
}
