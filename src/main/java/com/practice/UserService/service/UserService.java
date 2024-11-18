package com.practice.UserService.service;

import com.practice.UserService.dto.UserDto;
import com.practice.UserService.entity.User;
import com.practice.UserService.mapper.UserMapper;
import com.practice.UserService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserDto saveUser(UserDto userDto) {

    User user = UserMapper.INSTANCE.mapUserDtoToUser(userDto);

          User saveduser= userRepository.save(user);
          UserDto saveduserDto =
                  UserMapper.INSTANCE.mapUserToUserDto(saveduser);
          return saveduserDto;
    }

    public ResponseEntity<UserDto> fetchByUserId(Integer id)
    {
    Optional<User> foundUser = userRepository.findById(id);

    if(foundUser.isPresent()) {
        UserDto founduserDto = UserMapper.INSTANCE.mapUserToUserDto(foundUser.get());
        return new ResponseEntity<>(founduserDto , HttpStatus.FOUND);
    }
       else
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);

}}
