package com.example.boardproject.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //DB가 해당객체를 인식 하게 해줌
@AllArgsConstructor
@ToString
@NoArgsConstructor // defalut constructor
public class Article {

    @Id
    @GeneratedValue //ID값이 1,2,3 자동 생성하게 해주는 기능
    private Long id;

    @Column
    private String title;
    @Column
    private String content;

}
