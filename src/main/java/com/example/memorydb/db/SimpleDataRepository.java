package com.example.memorydb.db;

import com.example.memorydb.entity.Entity;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<T>();
    private static long index = 0;
    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId()); // 오름차순
        }
    };

    // Create, Update

    @Override
    public T save(T data) {
        if (Objects.isNull(data)) {
            throw new RuntimeException("Data is null");
        }

        // DB에 데이터가 이미 존재하는지 확인
        var prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId());
                })
                .findFirst();

        if (prevData.isPresent()) {
            // 기존 데이터가 있는 경우
            dataList.remove(prevData);
            dataList.add(data);
        } else {
            // 기존 데이터가 없는 경우
            index++;
            data.setId(index);
            dataList.add(data);

        }

        // unique id
        data.setId(index);
        dataList.add(data);
        index++;
        return null;
    }

    // Read
    @Override
    public Optional<T> findById(ID id) {
        return dataList.stream()
                .filter(it -> {
                    return it.getId().equals(id);
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .collect(Collectors.toList());
    }

    // Delete

    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(id);
                })
                .findFirst();

        if (deleteEntity.isPresent()) {
            dataList.remove(deleteEntity);
        }
    }
}
