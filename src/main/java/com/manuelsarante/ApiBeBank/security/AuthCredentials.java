package com.manuelsarante.ApiBeBank.security;

import lombok.Data;

@Data
public class AuthCredentials {

    private String user;
    private String password;
}
