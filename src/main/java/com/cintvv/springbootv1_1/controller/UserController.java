package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {

    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({ "list"})
    public String showAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "list";
    }

    @GetMapping(value = {"/add" })
    public String addUser(Model model) {
        User newUser = new User();
        model.addAttribute("user", newUser);
        return "add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/list";
    }

    @RequestMapping(value = "/edit/{id}")
    public ModelAndView updateUser(@PathVariable Integer id) {
        ModelAndView mav = new ModelAndView("edit");
        User user = userService.getUserById(id);
        mav.addObject("user", user);
        return mav;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateUserAfterWriting(@PathVariable Integer id, @ModelAttribute("user") User user) {
        User user1 = userService.getUserById(id);
        user1.setId(user.getId());
        user1.setName(user.getName());
        user1.setLastName(user.getLastName());
        user1.setEmail(user.getEmail());
        userService.updateUser(user1);
        return "redirect:/list";
    }

    @RequestMapping(value = "/remove/{id}")
    public String removeUser(@PathVariable Integer id) {
        userService.removeUserById(id);
        return "redirect:/list";
    }
}
