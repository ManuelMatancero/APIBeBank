package com.manuelsarante.ApiBeBank.service;

import com.manuelsarante.ApiBeBank.domain.User;
import com.manuelsarante.ApiBeBank.dto.LoginDto;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public List<User> getAll();
    public User findById(Long id);
    public void insert(User user);
    public void update(User user);
    public void delete(User user);

    User findByUser(String user);


}
