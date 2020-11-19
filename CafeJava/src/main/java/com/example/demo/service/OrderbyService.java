package com.example.demo.service;

import com.example.demo.entity.Orderby;

import java.util.List;

public interface OrderbyService {
    public void create (Orderby orderby) throws Exception;
    public void remove (Orderby orderNo) throws Exception;
    public List<Orderby> list (String place) throws Exception;
}
