package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */
public interface CardsDao extends JpaRepository<Cards, Long> {
}
