package org.arip.multitenancy.service;

import org.arip.multitenancy.model.User;

import java.util.List;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
public interface UserService {

    List<User> getUsers();
}
