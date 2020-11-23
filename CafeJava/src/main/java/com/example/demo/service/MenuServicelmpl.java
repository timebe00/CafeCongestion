package com.example.demo.service;

import com.example.demo.entity.Menu;
import com.example.demo.repository.MenuRepository;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log
@Service
public class MenuServicelmpl implements MenuService {

    @Autowired
    private MenuRepository repository;

    @Override
    public Boolean create(Menu menu) throws Exception {
        repository.save(menu);
        return true;
    }

    @Override
    public void remove(Menu menuno) throws Exception {
        repository.delete(menuno);
    }

    @Override
    public List<Menu> show(String place) throws Exception {
        log.info("Service Menu Show");
        return repository.findByPlace(place);

//        log.info(String.valueOf(test));
//        return test;
//        return repository.show(place);

        //  업로드
//        Optional<Menu> menu = repository.findById(Long.valueOf("3"));
//        Menu obj = menu.get();
//        obj.setPlace("replace");
//        repository.save(obj);

//        repository.save(obj);

    }
}
