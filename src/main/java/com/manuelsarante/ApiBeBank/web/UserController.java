package com.manuelsarante.ApiBeBank.web;

import com.manuelsarante.ApiBeBank.domain.Logs;
import com.manuelsarante.ApiBeBank.domain.User;
import com.manuelsarante.ApiBeBank.dto.LoginDto;
import com.manuelsarante.ApiBeBank.dto.LoginWithPinDto;
import com.manuelsarante.ApiBeBank.service.LogsService;
import com.manuelsarante.ApiBeBank.service.UserService;
import com.manuelsarante.ApiBeBank.specialfunctions.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
/*
 * Copyright (c) Manuel Antonio Sarante Sanchez 2023
 * All rights reserved.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LogsService logsService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        //Here i encoded the password and PIN
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encPassword = encoder.encode(user.getPassword());
        String encPin = encoder.encode(user.getPin());
        user.setPassword(encPassword);
        user.setPin(encPin);
        //Check if there is a same user created in the database or an email
        boolean userIsValid = true;
        boolean emailIsValid = true;
        List<User> users = userService.getAll();
        for(User username: users){
            if (user.getUser().equals(username.getUser())) {
                userIsValid = false;
                break;
            }
        }
        for (User userEmail: users){
            if(user.getEmail().equals(userEmail.getEmail())){
                emailIsValid = false;
                break;
            }

        }
        //Here if user is Valid the user will be crated only if email is also valid
        if(userIsValid){
            //Save User if email is valid
            if(emailIsValid){
                userService.insert(user);
                return ResponseEntity.ok(new Messages("User created successfully"));
            }else{
                return ResponseEntity.ok(new Messages("The email is already in use"));
            }
        }else {
            return ResponseEntity.ok(new Messages("The user is already in use"));
        }
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        //Object to decode password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String message;
        String action = "Login";
        User user = userService.findByUser(loginDto.getUser());
        if(user!=null){
            if(encoder.matches(loginDto.getPassword(), user.getPassword())){
                message = "Connection Successful";
                Logs log = new Logs();
                log.setUser(user);
                log.setAction(action);
                log.setDate(LocalDateTime.now());
                log.setMessage(message);
                logsService.insert(log);
                return ResponseEntity.ok(user);
            }else{
                message = "Incorrect Password";
                Logs log = new Logs();
                log.setUser(user);
                log.setAction(action);
                log.setDate(LocalDateTime.now());
                log.setMessage(message);
                logsService.insert(log);
                return ResponseEntity.notFound().build();

            }
        }else{
            return ResponseEntity.notFound().build();

        }
    }

    @PostMapping("/pinlogin")
    public ResponseEntity<?> loginWithPin(@RequestBody LoginWithPinDto loginWithPinDto){
        //Object to decode password
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String message;
        String action = "Login PIN";
        User user = userService.findByUser(loginWithPinDto.getUser());
        if(user!=null){
            if(encoder.matches(loginWithPinDto.getPin(), user.getPin())){
                if(encoder.matches(loginWithPinDto.getPassword(), user.getPassword())){
                    message = "Connection with PIN Successful";
                    Logs log = new Logs();
                    log.setUser(user);
                    log.setAction(action);
                    log.setDate(LocalDateTime.now());
                    log.setMessage(message);
                    logsService.insert(log);
                    return ResponseEntity.ok(user);
                }else{
                    message = "Incorrect Password";
                    Logs log = new Logs();
                    log.setUser(user);
                    log.setAction(action);
                    log.setDate(LocalDateTime.now());
                    log.setMessage(message);
                    logsService.insert(log);
                    return ResponseEntity.notFound().build();

                }
            }else{
                message = "Incorrect PIN";
                Logs log = new Logs();
                log.setUser(user);
                log.setAction(action);
                log.setDate(LocalDateTime.now());
                log.setMessage(message);
                logsService.insert(log);
                return ResponseEntity.notFound().build();
            }

        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User user){
        //Variable to encode Password
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User userFound = userService.findById(id);
        if (userFound != null){
            userFound.setName(user.getName());
            userFound.setEmail(user.getEmail());
            userFound.setUser(user.getUser());
            //Here i encode the password
            String password = passwordEncoder.encode(user.getPassword());
            userFound.setPassword(password);
            userFound.setRole(user.getRole());
            userFound.setStatus(user.getStatus());
            //here i encode the pin
            String pin = passwordEncoder.encode(user.getPin());
            userFound.setPin(pin);
            userService.update(userFound);
            return ResponseEntity.ok(userFound);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/list")
    public ResponseEntity<?> listUsers() {
        List<User> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getObjectById(@PathVariable Long id) {
        User user = userService.findById(id);
        if (user==null) {
            return ResponseEntity.notFound().build();
        }else{
            return ResponseEntity.ok(user);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteuser(@PathVariable Long id){
        User user = userService.findById(id);
        if(user!=null){
            userService.delete(user);
            return ResponseEntity.ok(new Messages("User deleted"));
        }else{
           return ResponseEntity.notFound().build();
        }
    }
}
