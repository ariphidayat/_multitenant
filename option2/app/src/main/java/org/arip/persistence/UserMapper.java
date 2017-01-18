package org.arip.persistence;

import org.arip.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
@Repository
public interface UserMapper {

    List<User> getUsers();

    void create(User user);
}
