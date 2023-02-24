package com.progettofinale.greenhouse_be;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import lombok.extern.slf4j.Slf4j;
import com.progettofinale.greenhouse_be.service.UserService;
import com.progettofinale.greenhouse_be.model.User;
import com.progettofinale.greenhouse_be.model.Reservation;
import com.progettofinale.greenhouse_be.service.ReservationService;

@Component
@Slf4j
public class MyApplicationRunner implements CommandLineRunner {

    @Autowired
    UserService userService;

    @Autowired
    ReservationService reservationService;
    
    @Override
    public void run(String... args) throws Exception {

        log.info("run go");

        User u1 = new User("nik", "tizz", LocalDate.parse("1987-10-16"), "nik@myemail.it");
        User u2 = new User("mia", "toretto", LocalDate.parse("1990-03-20"), "mia@myemail.it");

        userService.saveUser(u1);
        userService.saveUser(u2);

        Reservation r1 = new Reservation("foggia", "puglia", "via degli ulivi", "mario", "rossi", "3296843972", LocalDateTime.of(2023,03,15,10,30,00), "mr@myemail.it");
        Reservation r2 = new Reservation("manfredonia", "puglia", "via kennedy", "gianna", "santoro", "3489333900",LocalDateTime.of(2023, 03, 20, 11, 00, 00), "gianna@myemail.it");

        reservationService.saveReservation(r1);
        reservationService.saveReservation(r2);
    }
}
