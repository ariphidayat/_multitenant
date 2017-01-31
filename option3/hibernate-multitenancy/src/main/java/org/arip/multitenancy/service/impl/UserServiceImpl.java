package org.arip.multitenancy.service.impl;

import org.arip.multitenancy.dao.UserDao;
import org.arip.multitenancy.model.User;
import org.arip.multitenancy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userdao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getUsers() {
        return userdao.getUsers();
    }
}
