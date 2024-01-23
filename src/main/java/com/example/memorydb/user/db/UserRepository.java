package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from user where score >= ??
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score); // 쿼리문과 자동 매핑: findAllBy / [필드 변수 이름] / 조건


    // select * from user where score >= ?? and score <= ??
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int minScore, int maxScore);
}
