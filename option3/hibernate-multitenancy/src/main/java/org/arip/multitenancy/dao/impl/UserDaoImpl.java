package org.arip.multitenancy.dao.impl;

import org.arip.multitenancy.dao.UserDao;
import org.arip.multitenancy.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Arip Hidayat on 21/07/2016.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
}
