package com.example.demo.service;

import com.example.demo.entity.PlaceList;

import java.util.List;

public interface PlaceListService {
    public List<PlaceList> findplace() throws Exception;
    public void create(PlaceList placeList) throws Exception;
}
