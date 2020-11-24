package com.example.demo.service;

import com.example.demo.entity.PlaceList;
import com.example.demo.repository.PlaceListReposirory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log
@Service
public class PlaceListServicelmpl implements PlaceListService {

    @Autowired
    private PlaceListReposirory reposirory;

    @Override
    public void create(PlaceList placeList) throws Exception {
        reposirory.save(placeList);
    }

    @Override
    public List<PlaceList> findplace() throws Exception {
        log.info("findplace");
        return reposirory.findBy();
    }
}
