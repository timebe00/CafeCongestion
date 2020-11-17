package com.example.demo.service;

import com.example.demo.entity.Register;
import com.example.demo.repository.RegisterReposirory;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Log
@Service
public class RegistrerServicelmpl implements RegisterService{

    @Autowired
    private RegisterReposirory reposirory;

    @Override
    public Boolean register(Register register) throws Exception {
        log.info("Register Service Register");

        if (register.getId().length() > 4 && register.getPw().length() > 16 && register.getNn().length() > 4 && register.getPn() >=100000000 &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId()) &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([1-9])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([!@#$%^&*(),.?\":{}|<>])+).*$",register.getPw()) &&
                Pattern.matches("^[0-9]*$",String.valueOf(register.getPn()))
        ) {
            log.info("Register Service Register");
            reposirory.save(register);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Boolean overlapID(Register register) throws Exception {
        log.info("Register Service Overlap");
        if(register.getId().length() > 4 && Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId()))
        {
            boolean TF = reposirory.existsById(register.getId());
            log.info("TF : " + TF);
            return TF ? false : true;
        }
        return false;
    }

    @Override
    public Boolean overlapNN(Register register) throws Exception {
        log.info("Register Service Overlap");
        if(register.getNn().length() > 4)
        {
            boolean TF = reposirory.existsByNn(register.getNn());

            return TF ? false : true;
        }
        return false;
    }

    @Override
    public Register findID(Register register) throws Exception {
        log.info("Register Service Find ID");
        if(register.getPn() >=1000000000 && Pattern.matches("^[0-9]*$",String.valueOf(register.getPn()))
        ) {
            Register getforid;
            getforid = reposirory.findByNameAndPn(register.getName(), register.getPn()).get(0);
            return getforid;
        }
        return null;
    }

    @Override
    public Register findPw(Register register) throws Exception {
        log.info("Register Service Find Pw");
        if(register.getId().length() > 4 && Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId())
        ) {
            Register getforid;
            getforid = reposirory.findByNameAndIdAndPn(register.getName(), register.getId(), register.getPn()).get(0);
            return getforid;
        }
        return null;
    }

    @Override
    public Boolean uplodPw(Register register) throws Exception {
        log.info("Register Service Up Lod Pw");
        if(register.getPw().length() > 16 &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([1-9])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([!@#$%^&*(),.?\":{}|<>])+).*$",register.getPw())
        ) {
            log.info("Clear");
            Register upLode = reposirory.findById(register.getId()).get(0);
            upLode.setPw(register.getPw());
            reposirory.save(upLode);
            return true;
        }
        return false;
    }

    @Override
    public Register login(Register register) throws Exception {
        log.info("Register Service Login");
        if(register.getId().length() > 4 && register.getPw().length() > 16 &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getId()) &&
                Pattern.matches("^.*(([a-zA-Z])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([1-9])+).*$",register.getPw()) &&
                Pattern.matches("^.*(([!@#$%^&*(),.?\":{}|<>])+).*$",register.getPw())
        ) {
            Register getid = reposirory.findByIdAndPw(register.getId(), register.getPw()).get(0);
            return getid;
        }
        return null;
    }
}

/*
    아이디	(중복)
    비밀번호
    닉네임	(중복)
    주소
    전화번호	(gsm 사용시 확인 문자)

    로그인(아이디 비번)
    아이디 찾기(이름, 전화번호)
    비밀번호(이름 아이디 전화번호)
 */