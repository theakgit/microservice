package com.ak.microservice.hotelmicro.controller;


import com.ak.microservice.hotelmicro.Payload.UserDto;
import com.ak.microservice.hotelmicro.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto dto) {
        UserDto userDto = userService.addUser(dto);
        return new ResponseEntity<>(userDto, HttpStatus.CREATED);
    }

    @GetMapping
    public List<UserDto> getAllUser(UserDto dto) {
        List<UserDto> allUser = userService.getAllUser(dto);
        return allUser;
    }

    @GetMapping("/{userid}")
    public ResponseEntity<UserDto> findUser(@PathVariable String userid) {
        UserDto userById = userService.findUserById(userid);
        return new ResponseEntity<>(userById, HttpStatus.OK);


    }
}
