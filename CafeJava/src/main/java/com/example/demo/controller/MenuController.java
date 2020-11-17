package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.entity.Register;
import com.example.demo.service.MenuService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

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
    public ResponseEntity<List<Menu>> show(@Validated @RequestBody HashMap place) throws Exception {
        log.info("Controller Menu Show");
        String pl = String.valueOf(place.get("place"));
        log.info(pl);
        List<Menu> getMU = service.show(pl);
        log.info("list len : " + getMU);
        return new ResponseEntity<List<Menu>>(getMU, HttpStatus.OK);
    }
}
