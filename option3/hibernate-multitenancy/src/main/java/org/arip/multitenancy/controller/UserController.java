package org.arip.multitenancy.controller;

import org.arip.multitenancy.model.User;
import org.arip.multitenancy.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.List;

/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @RequestMapping(value = "/{schema}", method = RequestMethod.GET)
    public String getUsers(@PathVariable("schema") String schema, Model model) {
        RequestContextHolder.getRequestAttributes().setAttribute("CURRENT_TENANT_IDENTIFIER", schema, RequestAttributes.SCOPE_REQUEST);

        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "user/list";
    }
}
