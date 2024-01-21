package com.example.memorydb.user.controller;

import com.example.memorydb.user.model.UserEntity;
import com.example.memorydb.user.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity
    ) {
        return userService.save(userEntity);
    }

    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

    @GetMapping(path = "/find/{userId}")
    public Optional<UserEntity> findById(
            @PathVariable String userId
    ) {
        return userService.findById(Long.valueOf(userId));
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(
            @PathVariable String userId
    ) {
        userService.delete(Long.valueOf(userId));
    }


}
