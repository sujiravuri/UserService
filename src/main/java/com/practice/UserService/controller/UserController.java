package com.practice.UserService.controller;

import com.practice.UserService.dto.UserDto;
import com.practice.UserService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Users")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDto> saveAllUsers
            (UserDto userDto)
    {
     UserDto savedUser =userService.saveUser(userDto);
     return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<UserDto> findByUserId(@PathVariable Integer id){
        return userService.fetchByUserId(id);
    }

}
