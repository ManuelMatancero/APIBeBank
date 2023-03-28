package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.Cards;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardsDao extends JpaRepository<Cards, Long> {
}
