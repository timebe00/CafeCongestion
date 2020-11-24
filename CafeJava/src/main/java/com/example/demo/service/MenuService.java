package com.example.demo.service;

import com.example.demo.entity.Menu;

import java.util.List;

public interface MenuService {
    public void create(Menu menu) throws Exception;
    public void remove(Menu menuno) throws Exception;
    public List<Menu> show(String place) throws Exception;
}
