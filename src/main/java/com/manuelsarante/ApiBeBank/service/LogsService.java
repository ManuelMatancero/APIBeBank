package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.domain.Logs;

import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

public interface LogsService {

    public List<Logs> getAll();
    public Logs findById(Long id);
    public void insert(Logs logs);
    public void update(Logs logs);
    public void delete(Logs logs);
}
