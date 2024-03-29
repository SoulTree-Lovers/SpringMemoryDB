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
import org.springframework.web.bind.annotation.RequestParam;
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
            @PathVariable Long userId
    ) {
        return userService.findById(userId);
    }

    @DeleteMapping("/delete/{userId}")
    public void delete(
            @PathVariable Long userId
    ) {
//        userService.delete(userId);
    }

    // score가 minScore 이상인 사용자의 정보를 찾아주는 method
    @GetMapping("/find/over")
    public List<UserEntity> findOver(
            @RequestParam int minScore // 파라미터로 받기
    ) {
        return userService.findOver(minScore);
    }

    // score가 minScore 이상인 사용자의 정보를 찾아주는 method
    @GetMapping("/find/min_max")
    public List<UserEntity> findMinMax(
            @RequestParam int minScore, // 파라미터로 받기
            @RequestParam int maxScore // 파라미터로 받기
    ) {
        return userService.findMinMax(minScore, maxScore);
    }
}
