package com.ks.cinema_site.repositories;

import com.ks.cinema_site.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String name);
    Optional<UserEntity> findByUsernameAndPassword(String name, String pass);
}
