package PreProject3.config;

import PreProject3.model.Role;
import PreProject3.model.User;
import PreProject3.service.RoleServiceImpl;
import PreProject3.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleServiceImpl roleService;

    public DataInitializer(UserService userService, RoleServiceImpl roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    @Transactional
    public void init() {
        Role adminRole = roleService.findByName("ROLE_ADMIN");
        if (adminRole == null) {
            adminRole = new Role("ROLE_ADMIN");
            roleService.save(adminRole);
        }

        Role userRole = roleService.findByName("ROLE_USER");
        if (userRole == null) {
            userRole = new Role("ROLE_USER");
            roleService.save(userRole);
        }

        if (userService.findByEmail("admin@mail.ru") == null) {
            User admin = new User();
            admin.setFirstName("Admin");
            admin.setLastName("Admin");
            admin.setAge(35);
            admin.setEmail("admin@mail.ru");
            admin.setPassword("admin");
            admin.setRoles(Set.of(adminRole, userRole));

            userService.createUser(admin, Set.of("ROLE_ADMIN", "ROLE_USER"));
        }
    }
}