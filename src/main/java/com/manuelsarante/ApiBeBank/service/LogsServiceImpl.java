package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.dao.LogsDao;
import com.manuelsarante.ApiBeBank.domain.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

@Service
public class LogsServiceImpl implements LogsService{

    @Autowired
    private LogsDao logsDao;
    @Override
    @Transactional(readOnly = true)
    public List<Logs> getAll() {
        return logsDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Logs findById(Long id) {
        return logsDao.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public void insert(Logs logs) {
        logsDao.save(logs);
    }
    @Override
    @Transactional
    public void update(Logs logs) {
        logsDao.save(logs);
    }
    @Override
    @Transactional
    public void delete(Logs logs) {
        logsDao.delete(logs);
    }

}
