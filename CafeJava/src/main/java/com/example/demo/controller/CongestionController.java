package com.example.demo.controller;


import lombok.extern.java.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Log
@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CongestionController {
    HashMap<String, Integer> people = new HashMap<String, Integer>();

    @GetMapping("/opencv/{place2}")
    public String opencv(@PathVariable String place2) throws Exception {
        log.info("place :" + place2);
        return "opencv";
    }

    @ResponseBody
    @PostMapping("/CVpeople")
    public void CVpeople(@RequestBody HashMap<String, String> values) throws Exception {
        int people = Integer.valueOf(values.get("value"));
        String place = values.get("plack");
        log.info(String.valueOf(people));
        log.info(place);
        this.people.put(place, people);
    }

    @ResponseBody
    @PostMapping("/getpeople")
    public ResponseEntity<Integer> getpeople(@RequestBody HashMap<String ,String> place) throws Exception {
        log.info("place : " + place);
        String Myplace = place.get("pl");
        log.info("Myplace : " + Myplace);
        int peopleNum = people.get(Myplace);
        log.info("peopleNum : " + peopleNum);
        return new ResponseEntity<>(peopleNum ,HttpStatus.OK);
    }
}
