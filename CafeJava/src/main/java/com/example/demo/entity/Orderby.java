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
@EqualsAndHashCode(of = "orderNo")
@ToString
@Entity
@Table(name = "orderby")
public class Orderby {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //  주문 번호
    @Column(name = "orderNo")
    private Long orderNo;

    //  주문자 아이디
    @Column(nullable = false, length=100, name = "id")
    private String id;

    //  주문 한것
    @Column(nullable = false, name = "ordername")
    private String orders;

    //  카페 위치
    @Column(nullable = false, name = "place")
    private String place;

    //  싸이즈
    @Column(nullable = false, name = "size")
    private String size;
}
