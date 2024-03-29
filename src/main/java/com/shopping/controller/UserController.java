package com.shopping.controller;

import com.shopping.model.User;
import com.shopping.service.UserService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Heidar
 */
@Controller
public class UserController {

    @Autowired
    private UserService serv;

    @GetMapping("/")
    public String showHomePage(Model model) {
        model.addAttribute("user", new User());
        return "home";
    }

    @GetMapping("/registration")
    public String Register(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/process")
    public String ShowSuccessPage(@Valid @ModelAttribute("user") User user, BindingResult result) {
        user.setRole("ROLE_USER");
        user.setPassword(serv.enCryptedPassword(user));
        if (result.hasErrors()) {
            System.out.println(result.toString());
            return "registration";
        } else {
            serv.save(user);
        }
        return "login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model) {
        return "login";
    }

    @RequestMapping("/default")
    public String defaultAfterLogin(HttpServletRequest request) {
        if (request.isUserInRole("ROLE_ADMIN")) {
            return "redirect:/admin/admin_products";
        }
        return "redirect:/user/product";
    }
}
