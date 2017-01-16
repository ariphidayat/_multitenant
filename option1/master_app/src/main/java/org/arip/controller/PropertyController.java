package org.arip.controller;

import org.arip.domain.Property;
import org.arip.service.PropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Arip Hidayat on 18/04/2016.
 */
@RestController
public class PropertyController {

    private static final Logger logger = LoggerFactory.getLogger(PropertyController.class);

    @Autowired
    PropertyService propertyService;

    @ResponseBody
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Property getById(@PathVariable("id") String id) {
        return propertyService.getById(id);
    }
}
