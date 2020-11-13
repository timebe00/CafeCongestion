package com.example.demo.service;

import com.example.demo.entity.Menu;

public interface MenuService {
    public Boolean create(Menu menu) throws Exception;
    public Menu show(String place) throws Exception;
}
