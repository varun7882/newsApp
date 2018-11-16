package com.varun.newsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varun.newsapp.model.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article,Integer>{

}
