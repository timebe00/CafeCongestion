package com.example.demo.controller;


import lombok.extern.java.Log;
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
    @PostMapping("CVpeople")
    public void testurl(@RequestBody HashMap<String, String> values) throws Exception {
        int people = Integer.valueOf(values.get("value"));
        String place = values.get("plack");
        log.info(String.valueOf(people));
        log.info(place);
        this.people.put(place, people);
    }
}
