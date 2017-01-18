package org.arip.controller;

import org.arip.config.multitenant.TenantContext;
import org.arip.domain.Property;
import org.arip.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@Controller
public class PropertyController {

    private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    PropertyService propertyService;

    @RequestMapping(value = "/property", method = RequestMethod.GET)
    public String getUsers(Model model) {
        TenantContext.setCurrentTenant("tenant_default");
        List<Property> properties = propertyService.getProperties();
        model.addAttribute("properties", properties);
        return "property/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update() {
        propertyService.updateProperties();
        return "redirect:/property";
    }
}
