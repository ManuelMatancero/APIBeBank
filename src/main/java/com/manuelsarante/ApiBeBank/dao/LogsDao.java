package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsDao extends JpaRepository<Logs, Long> {
}
