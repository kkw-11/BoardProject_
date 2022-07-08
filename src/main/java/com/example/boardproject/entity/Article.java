package com.example.boardproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity //DB가 해당객체를 인식 하게 해줌
public class Article {
    @Id
    @GeneratedValue //ID값이 1,2,3 자동 생성하게 해주는 기능
    private Long id;

    @Column
    private String title;
    @Column
    private String content;


    public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
