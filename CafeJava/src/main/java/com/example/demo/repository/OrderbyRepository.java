package com.example.demo.repository;


import com.example.demo.entity.Menu;
import com.example.demo.entity.Orderby;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface OrderbyRepository extends JpaRepository<Orderby, Long> {
    List<Orderby> findByPlace(String place);
}
