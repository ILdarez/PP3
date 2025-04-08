package PreProject3.service;

import PreProject3.dao.UserDao;
import PreProject3.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserById(Long id) {
        return userDao.getUserById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> showAllUsers() {
        return userDao.showAllUsers();
    }

    @Override
    @Transactional
    public void save(User user) {
        userDao.save(user);
    }


    @Override
    @Transactional
    public void update(Long id, String name, String lastname, Integer age) {
        User user = userDao.getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setLastName(lastname);
            user.setAge(age);
            userDao.update(user);
        }
    }

    @Override
    @Transactional
    public void delete(Long id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            userDao.delete(user);
        }
    }
}
