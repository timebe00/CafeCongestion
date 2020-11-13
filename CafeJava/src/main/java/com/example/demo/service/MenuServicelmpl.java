package com.example.demo.service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Log
@Service
public class MenuServicelmpl implements MenuService {
    @Autowired
    private MenuRepository repository;

    @Override
    public Boolean create(Menu menu) throws Exception {
        repository.create(menu);
        return true;
    }

    @Override
    public Menu show(String place) throws Exception {
        Menu test = repository.show(place);
        log.info(String.valueOf(test));
        return test;
//        return repository.show(place);
    }
}
