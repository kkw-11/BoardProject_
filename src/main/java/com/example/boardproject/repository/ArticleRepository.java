package com.example.boardproject.repository;

import com.example.boardproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {


    @Override
    ArrayList<Article> findAll();
}
