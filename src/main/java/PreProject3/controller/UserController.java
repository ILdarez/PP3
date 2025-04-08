package PreProject3.controller;

import PreProject3.model.User;
import PreProject3.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.showAllUsers());
        return "users";
    }

    @PostMapping("/addUser")
    public String addUser(
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("age") Integer age) {

        userService.save(new User(name, lastname, age));
        return "redirect:/";
    }

    @GetMapping("/editUser")
    public String editUser(@RequestParam("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "editUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(
            @RequestParam("id") Long id,
            @RequestParam("name") String name,
            @RequestParam("lastname") String lastname,
            @RequestParam("age") Integer age) {

        userService.update(id, name, lastname, age);
        return "redirect:/";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Long id) {
        userService.delete(id);
        return "redirect:/";
    }
}