package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.dao.CardsDao;
import com.manuelsarante.ApiBeBank.domain.Cards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */

@Service
public class CardsServiceImpl implements CardsService{

    @Autowired
    private CardsDao cardsDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cards> getAll() {
        return cardsDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cards findById(Long id) {
        return cardsDao.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public void insert(Cards cards) {
        cardsDao.save(cards);
    }
    @Override
    @Transactional
    public void update(Cards cards) {
        cardsDao.save(cards);
    }
    @Override
    @Transactional
    public void delete(Cards cards) {
        cardsDao.delete(cards);
    }
}
