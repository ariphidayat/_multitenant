package org.arip.persistence;

import org.arip.domain.Property;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
public interface PropertyMapper {

    Property getById(String id);
}
