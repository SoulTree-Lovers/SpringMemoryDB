package com.example.memorydb.user.db;

import com.example.memorydb.db.SimpleDataRepository;
import com.example.memorydb.user.model.UserEntity;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    public List<UserEntity> findOver(Long minScore) {
        return this.findAll().stream()
                .filter(user -> {
                    return user.getScore() >= minScore;
                }).collect(Collectors.toList());
    }
}
