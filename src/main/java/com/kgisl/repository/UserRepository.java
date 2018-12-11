package com.kgisl.repository;

import com.kgisl.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TeamRepository
 */
public interface UserRepository extends JpaRepository<User, Long> {

    
}