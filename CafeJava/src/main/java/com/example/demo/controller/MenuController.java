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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
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

    @PostMapping("/remove")
    public void remove(@Validated @RequestBody Menu menuno) throws Exception {
        service.remove(menuno);
    }

    @PostMapping("/file")
    public ResponseEntity<String> sinup(HttpServletRequest request) throws Exception {
        log.info("Controller File Sin Up");
        MultipartHttpServletRequest mult = null;
        String original = "";
        if(request instanceof MultipartHttpServletRequest)       //  request가 MultipartHttpServletRequest 로형변환 가능한가
        {
            log.info("yes");
            mult = (MultipartHttpServletRequest)request;

            Iterator<String> iterator = mult.getFileNames();
            MultipartFile fil = mult.getFile(iterator.next());

            original = fil.getOriginalFilename();

            String fileTeg = original;

//            String filePath = "D:\\Git\\Bitcamp\\Project\\soproj1\\pythonwork";
            String filePath = "/home/bitai/proj/CafeCongestion/CafeVue/frontend/src/assets/CafeMenu";
            File folder = new File(filePath);

            if(!folder.exists()){
                folder.mkdirs();
            }

            File file = new File(filePath + File.separator + "asd" + fileTeg);
            fil.transferTo(file);

            return new ResponseEntity<String>(file.getAbsolutePath(),HttpStatus.OK);
        }

        return new ResponseEntity<String>(original,HttpStatus.OK);
    }
//
    @PostMapping("/fileremove")
    public void fileremove(@RequestBody String path) throws Exception
    {
        log.info("path : " + path);
        if(path != null) {
            File f = new File(path);
            log.info("echo");
            if(f.exists()){
                f.delete();
            }
        }
    }

}
