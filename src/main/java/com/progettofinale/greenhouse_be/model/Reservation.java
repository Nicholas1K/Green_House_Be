package com.progettofinale.greenhouse_be.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Reservation {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String city;

    @Column
    private String region;

    @Column
    private String address;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column(unique = true)
    private String telephonNumber;

    @Column(unique = true)
    private String email;

    @Column
    private LocalDateTime meetingTime;

    public Reservation(String city, String region, String address, String firstName, String lastName,
            String telephonNumber, LocalDateTime meetingTime, String email) {
        this.city = city;
        this.region = region;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephonNumber = telephonNumber;
        this.meetingTime = meetingTime;
        this.email = email;
    }
}
