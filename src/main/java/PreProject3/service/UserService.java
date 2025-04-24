package PreProject3.service;

import PreProject3.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    String addUser(User user);

    String updateUser(User user);

    String deleteUser(Long id);
}
