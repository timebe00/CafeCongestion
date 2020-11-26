package com.example.demo.repository;

import com.example.demo.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterReposirory extends JpaRepository<Register, Long> {
    //  아이디 중복확인
    boolean existsById(String id);
    //  닉네임 중복확인
    boolean existsByNn(String nn);
    //  아이디 찾기
    List<Register> findByNameAndPn(String name, String pn);
    //  비밀번호 찾기
    List<Register> findByNameAndIdAndPn(String name, String id, String pn);
    //  로그인
    List<Register> findByIdAndPw(String id, String pw);
    //  아이디 업로드
    List<Register> findById(String id);
}
