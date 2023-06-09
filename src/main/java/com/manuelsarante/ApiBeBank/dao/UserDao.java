package com.manuelsarante.ApiBeBank.dao;

import com.manuelsarante.ApiBeBank.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface UserDao extends JpaRepository<User, Long> {
    User findByUser(String user);

}
