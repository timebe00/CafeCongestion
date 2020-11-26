package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@JsonIgnoreProperties(value="hibernateLazyInitializer")
@Getter
@Setter
@EqualsAndHashCode(of = "userNo")
@ToString
@Entity
@Table(name = "register")
public class Register {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userno")
    //  키 값
    private Long userNo;
    //  이름
    @Column(name = "name", nullable = false)
    private String name;
    //  id
    @Column(name = "id", nullable = false, unique = true)
    private String id;
    // pw
    @Column(name = "pw", nullable = false)
    private String pw;
    //  Nickname
    @Column(name = "nn", nullable = false, unique = true)
    private String nn;
    //  Address
    @Column(name = "ad", columnDefinition = "TEXT")
    private String ad;
    //  Phone Number
    @Column(name = "pn", nullable = false)
    private String pn;
}