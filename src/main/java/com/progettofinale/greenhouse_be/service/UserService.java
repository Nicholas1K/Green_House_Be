package com.progettofinale.greenhouse_be.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.progettofinale.greenhouse_be.repository.UserRepository;
import com.progettofinale.greenhouse_be.model.User;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        Optional<User> tempUser = userRepository.findById(id);

        if(tempUser.isPresent()){
            return tempUser.get();
        }else{
            return null;
        }
    }
    
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUserById(User newUser, Long id){

        Optional<User> tempUser = userRepository.findById(newUser.getId());

        if(tempUser.isPresent()){

            User oldUser = tempUser.get();
            oldUser.setFirstname(newUser.getFirstname());
            oldUser.setLastname(newUser.getLastname());
            oldUser.setEmail(newUser.getEmail());
            oldUser.setDateOfBirth(newUser.getDateOfBirth());

            return userRepository.save(oldUser);
        }
        return null;
    }
}
