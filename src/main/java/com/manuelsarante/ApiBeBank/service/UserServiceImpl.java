package com.manuelsarante.ApiBeBank.service;


import com.manuelsarante.ApiBeBank.dao.UserDao;
import com.manuelsarante.ApiBeBank.domain.User;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return userDao.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public void insert(User user) {
        userDao.save(user);
    }
    @Override
    @Transactional
    public void update(User user) {
        userDao.save(user);
    }
    @Override
    @Transactional
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User findByUser(String user) {
        return userDao.findByUser(user);
    }


}
