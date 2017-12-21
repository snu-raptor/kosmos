package com.app.dao;

import com.app.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Viktar Kolbik
 * @since 12/17/17
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long>
{
}
