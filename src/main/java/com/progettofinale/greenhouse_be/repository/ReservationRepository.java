package com.progettofinale.greenhouse_be.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.progettofinale.greenhouse_be.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    
}
