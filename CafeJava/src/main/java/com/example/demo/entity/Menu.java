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
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //   메뉴 키값
    @Column(name = "menuno")
    private Long menuNo;
    //  이미지 이름
    @Column(name = "imgN", nullable = false)
    private String imgN;
    //  메뉴 이름
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "place", nullable = false)
    private String place;
    //  가격
    @Column(name = "pr", nullable = false)
    private int pr;
    //  싸이즈
    @Column(name = "va", nullable = true)
    private String va;
    @Column(name = "gr", nullable = true)
    private String gr;
    @Column(name = "ta", nullable = true)
    private String ta;
}
