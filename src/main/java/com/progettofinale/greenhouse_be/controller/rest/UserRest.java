package com.progettofinale.greenhouse_be.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.progettofinale.greenhouse_be.model.User;
import com.progettofinale.greenhouse_be.service.UserService;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserRest {
    
    @Autowired
    UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        
        return new ResponseEntity<>(userService.getAllUser(),HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){

        return new ResponseEntity<>(userService.findUserById(id),HttpStatus.OK );
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User newUser){

        return new ResponseEntity<User>(userService.saveUser(newUser), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable String id){
        
        Long idLong = Long.parseLong(id);

        userService.deleteUserById(idLong);

        return new ResponseEntity<>("user delete successful",HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUserById(@PathVariable Long id,@RequestBody User newUser){

        return new ResponseEntity<User>(userService.updateUserById(newUser, id),HttpStatus.OK);
    }
}
