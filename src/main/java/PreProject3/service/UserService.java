package PreProject3.service;

import PreProject3.model.User;


import java.util.List;

public interface UserService {
    User getUserById(Long id);

    List<User> showAllUsers();

    void save(User user);

    void update(Long id, String name, String lastname, Integer age);

    void delete(Long id);
}
