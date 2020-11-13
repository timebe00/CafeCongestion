package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Register;
import com.example.demo.service.MenuService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Log
@Controller
@RequestMapping("/menu")
@CrossOrigin(origins = "http://localhost:8080", allowedHeaders = "*")
public class MenuController {
    @Autowired
    private MenuService service;

    @PostMapping("/create")
    public Boolean create(@Validated @RequestBody Menu menu) throws Exception {
        return service.create(menu);
    }

    @PostMapping("/show")
    public Menu show(@Validated @RequestBody HashMap place) throws Exception {
        log.info("Controller Menu Show");
        String pl = String.valueOf(place.get("place"));
        log.info(pl);
        Menu test = service.show(pl);
        log.info(String.valueOf(test));
        return test;
//        return service.show(pl);
    }
}
