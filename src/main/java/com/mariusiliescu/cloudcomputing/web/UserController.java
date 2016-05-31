package com.mariusiliescu.cloudcomputing.web;

import com.mariusiliescu.cloudcomputing.model.User;
import com.mariusiliescu.cloudcomputing.service.SecurityService;
import com.mariusiliescu.cloudcomputing.service.UserService;
import com.mariusiliescu.cloudcomputing.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private UserValidator userValidator;

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("userForm", new User());

        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult, Model model) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }

        userService.save(userForm);

        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "redirect:/welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, HttpSession session, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = {"/", "/home" , "/welcome"}, method = RequestMethod.GET)
    public String welcome(Model model ,HttpSession session) {
        User user = null;
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        user = userService.findByUsername(username);

        session.setAttribute("loggedInUser", user);
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/view_r_tasks", method = RequestMethod.GET)
    public String viewResolvedTasks(Model model) {
        //model.addAttribute("userForm", new User());
        return "view_r_tasks";
    }

    @RequestMapping(value = "/my_tasks", method = RequestMethod.GET)
    public String myTasks(Model model) {
        //model.addAttribute("userForm", new User());
        return "my_tasks";
    }
    @RequestMapping(value = "/res_task", method = RequestMethod.GET)
    public String resolveTask(Model model) {
        //model.addAttribute("userForm", new User());
        return "res_task";
    }
    @RequestMapping(value = "/contact", method = RequestMethod.GET)
    public String contactUs(Model model) {
        //model.addAttribute("userForm", new User());
        return "contact";
    }
}
