package com.progettofinale.greenhouse_be.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progettofinale.greenhouse_be.repository.ReservationRepository;
import com.progettofinale.greenhouse_be.model.Reservation;



@Service
public class ReservationService {
    
    @Autowired
    ReservationRepository reservationRepository;

    public Reservation saveReservation(Reservation reservation){
        return reservationRepository.save(reservation);
    }

    public List<Reservation> getAllReservation(){
        return reservationRepository.findAll();
    }

    public Reservation findReservationById(Long id){
        Optional<Reservation> tempReserv = reservationRepository.findById(id);

        if(tempReserv.isPresent()){
            return tempReserv.get();
        }else{
            return null;
        }
    }

    public void deleteReservationById(Long id) {
        reservationRepository.deleteById(id);
    }

    public Reservation updateReservationById(Reservation newReservation, Long id){
        
        Optional<Reservation> tempReserv = reservationRepository.findById(newReservation.getId());

        if(tempReserv.isPresent()){

            Reservation oldReservation = tempReserv.get();
            oldReservation.setCity(newReservation.getCity());
            oldReservation.setRegion(newReservation.getRegion());
            oldReservation.setAddress(newReservation.getAddress());
            oldReservation.setFirstName(newReservation.getFirstName());
            oldReservation.setLastName(newReservation.getLastName());
            oldReservation.setEmail(newReservation.getEmail());
            oldReservation.setTelephonNumber(newReservation.getTelephonNumber());
            oldReservation.setMeetingTime(newReservation.getMeetingTime());

            return reservationRepository.save(oldReservation);
        }
        return null;
    }
}
