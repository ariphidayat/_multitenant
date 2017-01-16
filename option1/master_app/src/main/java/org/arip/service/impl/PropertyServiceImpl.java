package org.arip.service.impl;

import org.arip.domain.Property;
import org.arip.persistence.PropertyMapper;
import org.arip.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyMapper propertyMapper;

    public Property getById(String id) {
        return propertyMapper.getById(id);
    }
}
