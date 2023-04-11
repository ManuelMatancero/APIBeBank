package com.manuelsarante.ApiBeBank.web;


import com.manuelsarante.ApiBeBank.domain.Logs;
import com.manuelsarante.ApiBeBank.domain.User;
import com.manuelsarante.ApiBeBank.dto.LoginDto;
import com.manuelsarante.ApiBeBank.dto.LoginWithPinDto;
import com.manuelsarante.ApiBeBank.service.LogsService;
import com.manuelsarante.ApiBeBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LogsService logsService;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody User user){
        userService.insert(user);
        return ResponseEntity.ok(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        String message;
        String action = "Login";
        User user = userService.findByUser(loginDto.getUser());
        if(user!=null){
            if(user.getPassword().equals(loginDto.getPassword())){
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
        String message;
        String action = "Login PIN";
        User user = userService.findByUser(loginWithPinDto.getUser());
        if(user!=null){
            if(loginWithPinDto.getPin().equals(user.getPin())){
                if(loginWithPinDto.getPassword().equals(user.getPassword())){
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
        userService.delete(user);
        return ResponseEntity.ok("User Eliminado");
    }

}
