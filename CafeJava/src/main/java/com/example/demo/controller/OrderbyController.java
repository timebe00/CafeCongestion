package com.example.demo.controller;

import com.example.demo.entity.Orderby;
import com.example.demo.service.OrderbyServicelmpl;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Log
@RestController
@RequestMapping("/orderby")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class OrderbyController {

    @Autowired
    private OrderbyServicelmpl service;

    @PostMapping("/create")
    public void create(@Validated @RequestBody HashMap ord) throws Exception {
        log.info(""+ord);
        List<HashMap> ord2 = (List<HashMap>) ord.get("order");
        log.info(""+ord2.get(0).get("place"));
        for(int i=0; i<ord2.size(); i++)
        {
            Orderby orderby = new Orderby();
            orderby.setId(String.valueOf(ord2.get(i).get("id")));
            orderby.setOrders(String.valueOf(ord2.get(i).get("name")));
            orderby.setPlace(String.valueOf(ord2.get(i).get("place")));
            orderby.setSize(String.valueOf(ord2.get(i).get("size")));
            service.create(orderby);
        }
    }

    @PostMapping("/remove")
    public void remove(@Validated @RequestBody Orderby orderNo) throws Exception {
        service.remove(orderNo);
    }

    @PostMapping("/list")
    public ResponseEntity<List<Orderby>> orderlsit(@Validated @RequestBody HashMap<String, String> values) throws Exception {
        String place = values.get("place");

        log.info("Controller Orderby Order List");
        log.info(place);
        return new ResponseEntity<>(service.list(place), HttpStatus.OK);
    }
}
