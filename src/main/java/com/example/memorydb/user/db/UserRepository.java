package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    // select * from user where score >= ??
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score); // 쿼리문과 자동 매핑: findAllBy / [필드 변수 이름] / 조건


    // select * from user where score >= ?? and score <= ??
    public List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThanEqual(int minScore, int maxScore);


    // 위 메소드를 아래와 같이 네이티브 쿼리문을 직접 작성하는 방법도 가능하다. (JPQL)
    @Query(
            "select u from user u where u.score >= ?1 and u.score <= ?2"
    )
    public List<UserEntity> scoreJpql(int min, int max); // min: ?1, max: ?2


    // JPQL 대신 진짜 sql문으로 작성하고 싶다면, nativeQuery = true 값을 추가한다.
    @Query(
            value = "select * from user as u where u.score >= ?1 and u.score <= ?2",
            nativeQuery = true
    )
    public List<UserEntity> scoreNativeSql(int min, int max); // min: ?1, max: ?2

    // 아래와 같이 ?1과 ?2의 파라미터 이름을 지어줄 수 있다.
    @Query(
            value = "select * from user as u where u.score >= :min and u.score <= :max",
            nativeQuery = true
    )
    public List<UserEntity> scoreNativeSqlParam(
           @Param(value = "min") int min,
           @Param(value = "max") int max
    );
}
