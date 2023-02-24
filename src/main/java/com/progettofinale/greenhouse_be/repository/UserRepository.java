package com.progettofinale.greenhouse_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progettofinale.greenhouse_be.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
    
}
