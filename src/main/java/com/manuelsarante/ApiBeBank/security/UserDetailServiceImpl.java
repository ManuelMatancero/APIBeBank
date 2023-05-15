package com.manuelsarante.ApiBeBank.security;

import com.manuelsarante.ApiBeBank.domain.User;
import com.manuelsarante.ApiBeBank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = new User();
        try{
            user = userService.findByUser(username);
        }catch (UsernameNotFoundException e){
            e.printStackTrace(System.out);
        }
       return new UserDetailImpl(user);
    }
}
