package com.example.demo.controller;

import com.example.demo.entity.PlaceList;
import com.example.demo.service.PlaceListService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.BlockingDeque;

@Log
@RestController
@RequestMapping("/place")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PlaceListController {

    @Autowired
    private PlaceListService service;

    @PostMapping("/placecreate")
    public void create(@Validated @RequestBody PlaceList placeList) throws Exception {
        log.info("Place List create");
//        log.info("id : " + id + " / place : " + place);
//        PlaceList placeList = null;
//        placeList.setId(id);
//        placeList.setPlace(place);
        service.create(placeList);
    }

    @PostMapping("/getList")
    public List<PlaceList> getList() throws Exception {
        log.info("getList");
        return service.findplace();
    }
}
