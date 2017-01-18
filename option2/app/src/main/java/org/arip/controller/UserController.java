package org.arip.controller;

import org.arip.config.multitenant.TenantContext;
import org.arip.domain.User;
import org.arip.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(@RequestParam("tenant") String tenant, Model model) {
        TenantContext.setCurrentTenant(tenant);

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping(value = "new", method = RequestMethod.GET)
    public String createForm(@RequestParam("tenant") String tenant, Model model) {
        TenantContext.setCurrentTenant(tenant);

        User user = new User();
        model.addAttribute("user", user);

        return "user/create";
    }

    @RequestMapping(value = "new", method = RequestMethod.POST)
    public String create(@RequestParam("tenant") String tenant, User user) {
        TenantContext.setCurrentTenant(tenant);

        userService.create(user);
        return "redirect:/user?tenant=" + tenant;
    }
}
