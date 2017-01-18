package org.arip.persistence;

import org.arip.domain.Property;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
@Repository
public interface PropertyMapper {

    List<Property> getProperties();
}
