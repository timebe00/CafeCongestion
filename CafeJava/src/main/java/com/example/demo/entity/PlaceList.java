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
@EqualsAndHashCode(of = "placeNo")
@ToString
@Entity
@Table(name = "placelist")
public class PlaceList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  장소 위치 번호
    @Column(name = "placeNo")
    private Long placeNo;

    //  아이디
    @Column(nullable = false, length=100, name = "id")
    private String id;

    //  장소
    @Column(nullable = false, name = "place")
    private String place;
}
