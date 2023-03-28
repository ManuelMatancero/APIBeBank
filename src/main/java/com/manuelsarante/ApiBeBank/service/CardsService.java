package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.domain.Cards;

import java.util.List;

public interface CardsService {

    public List<Cards> getAll();
    public Cards findById(Long id);
    public void insert(Cards cards);
    public void update(Cards cards);
    public void delete(Cards cards);
}
