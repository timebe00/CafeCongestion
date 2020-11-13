package com.example.demo.repository;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Register;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Log
@Repository
public class MenuRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void create(Menu menu) throws Exception {
        log.info("Repository Menu Create");
        String query = "insert into menu(imgN, name, pr, va, gr, ta) values(?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(query, menu.getImgN(), menu.getName(), menu.getPr(), menu.getVa(), menu.getGr(), menu.getTa());
    }

    public Menu show(String place) throws Exception {
        log.info("Repository Menu show");

        List<Menu> res = jdbcTemplate.query(
                "select * from menu where place = ?",
                new RowMapper<Menu>() {
                    @Override
                    public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Menu menu = new Menu();
                        menu.setMenuNo(rs.getLong("menuno"));
                        menu.setImgN(rs.getString("imgN"));
                        menu.setName(rs.getString("name"));
                        menu.setName(rs.getString("place"));
                        menu.setPr(rs.getInt("pr"));
                        menu.setVa(rs.getInt("va"));
                        menu.setVa(rs.getInt("gr"));
                        menu.setVa(rs.getInt("ta"));

                        return menu;
                    }
                }, place
        );
        log.info("echo");
        return res.isEmpty() ? null : res.get(0);
    }
}
