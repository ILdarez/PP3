package PreProject3;


import PreProject3.model.User;
import PreProject3.service.UserService;
import PreProject3.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();

        List<User> users = userService.getAllUsers();
        System.out.println("Users: " + users);

        User newUser = new User(3L, "James", "Brown", (byte) 35);
        String part1 = userService.addUser(newUser);
        System.out.println("Part 1: " + part1);

        newUser.setName("Thomas");
        newUser.setLastName("Shelby");
        String part2 = userService.updateUser(newUser);
        System.out.println("Part 2: " + part2);

        String part3 = userService.deleteUser(3L);
        System.out.println("Part 3: " + part3);

        String finalCode = part1 + part2 + part3;
        System.out.println("Итоговый код: " + finalCode);
    }
}