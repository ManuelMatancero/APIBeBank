package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */
public interface LogsDao extends JpaRepository<Logs, Long> {
}
