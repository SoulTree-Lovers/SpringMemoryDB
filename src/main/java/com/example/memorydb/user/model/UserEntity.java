package com.example.memorydb.user.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity(name = "user") // user table과 연결
public class UserEntity {

    @Id // @Entity는 @Id 필드가 하나는 있어야 함.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // mysql db의 시스템에서 관리하도록 위임
    private Long id;
    private String name;
    private int score;

}
