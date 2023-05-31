package com.manuelsarante.ApiBeBank.web;

import com.manuelsarante.ApiBeBank.domain.Cards;
import com.manuelsarante.ApiBeBank.service.CardsService;
import com.manuelsarante.ApiBeBank.specialfunctions.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */
@RestController
@RequestMapping("/cards")
public class CardsController {
    @Autowired
    CardsService cardsService;
    @GetMapping("/list")
    public ResponseEntity<?> listCardss() {
        List<Cards> cardss = cardsService.getAll();
        return ResponseEntity.ok(cardss);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cards> getObjectById(@PathVariable Long id) {
        Cards cards = cardsService.findById(id);
        if (cards==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(cards);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletecards(@PathVariable Long id){
        Cards cards = cardsService.findById(id);
        cardsService.delete(cards);
        return ResponseEntity.ok(new Messages("Card deleted"));
    }
}
