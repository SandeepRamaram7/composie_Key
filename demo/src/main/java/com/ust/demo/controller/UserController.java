package com.ust.demo.controller;

import com.ust.demo.model.User;
import com.ust.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/v1")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/save")
    public User saveEmployee(@RequestBody User user){
        return userService.SaveUser(user);
    }
    @GetMapping("/{userId}/types/{userType}")
    public ResponseEntity<User> findUser(@PathVariable int userId, @PathVariable String userType){
        log.info("Finding user with userId: {} and userType: {} ", userId, userType);

        Optional<User> user = userService.findUser(userId, userType);

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
