package PreProject3.dao;


import PreProject3.model.User;

import java.util.List;

public interface UserDao {
    User getUserById(Long id);

    List<User> showAllUsers();

    void save(User user);

    void update(User user);

    void delete(User user);
}
