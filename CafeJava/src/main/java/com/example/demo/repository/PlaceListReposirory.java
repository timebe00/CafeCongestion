package com.example.demo.repository;

import com.example.demo.entity.Orderby;
import com.example.demo.entity.PlaceList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceListReposirory extends JpaRepository<PlaceList, Long> {
    List<PlaceList> findBy();
}
