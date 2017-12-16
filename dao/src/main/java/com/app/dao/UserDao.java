package com.app.dao;

import com.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Viktar Kolbik
 * @since 12/13/17
 */
@Repository
public interface UserDao extends JpaRepository<User, Long>{
  List<User> findByUserId( Long id );
}
