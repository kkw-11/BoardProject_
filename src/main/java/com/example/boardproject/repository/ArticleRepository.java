package com.example.boardproject.repository;

import com.example.boardproject.entity.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {



}
