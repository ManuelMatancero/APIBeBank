package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.domain.User;
import java.util.List;

/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

public interface UserService {

    public List<User> getAll();
    public User findById(Long id);
    public void insert(User user);
    public void update(User user);
    public void delete(User user);

    User findByUser(String user);


}
