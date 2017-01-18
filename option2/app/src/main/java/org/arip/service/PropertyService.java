package org.arip.service;

import org.arip.domain.Property;

import java.util.List;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
public interface PropertyService {

    List<Property> getProperties();

    Property create(Property property);

    void updateProperties();
}
