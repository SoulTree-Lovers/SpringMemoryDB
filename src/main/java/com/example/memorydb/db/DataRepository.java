package com.example.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository<T, ID> extends Repository<T, ID> {
    // Create, Update를 한꺼번에 (기존에 데이터가 있으면 Update, 없으면 Create)
    T save(T data);

    // Read
    Optional<T> findById(ID id);
    List<T> findAll();

    // Delete
    void delete(ID id);
}
