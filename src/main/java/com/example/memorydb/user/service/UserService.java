package com.example.memorydb.user.service;

import com.example.memorydb.user.db.UserRepository;
import com.example.memorydb.user.model.UserEntity;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    public UserEntity save(UserEntity userEntity) {
        // save
        return userRepository.save(userEntity);
    }

    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id) {
        return userRepository.findById(id);
    }

    public void delete(UserEntity id) {
        userRepository.delete(id);
    }

    // user의 score가 minScore 이상인 사용자의 정보를 찾아주는 method
    public List<UserEntity> findOver(int minScore) {
//        return null;
        return userRepository.findAllByScoreGreaterThanEqual(minScore);
    }

    // user의 score가 minScore 이상이고 maxScore 이하인 사용자의 정보를 찾아주는 method
    public List<UserEntity> findMinMax(int minScore, int maxScore) {
//        return null;
//        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThanEqual(minScore, maxScore);
//        return userRepository.scoreJpql(minScore, maxScore);
//        return userRepository.scoreNativeSql(minScore, maxScore);
        return userRepository.scoreNativeSqlParam(minScore, maxScore);
    }
}
