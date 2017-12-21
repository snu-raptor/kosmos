package com.app.dao;

import com.app.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Viktar Kolbik
 * @since 12/17/17
 */
@Repository
public interface ArticleDao extends JpaRepository<Article, Long>
{
}
