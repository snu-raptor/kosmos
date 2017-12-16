package com.app.web;

import com.app.dao.UserDao;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Viktar Kolbik
 * @since 12/13/17
 */
@RestController
@RequestMapping("/")
public class MainController
{
  @Autowired
  private UserDao userDao;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public List<User> test(@PathVariable("id") String id){
      List<User> users = userDao.findByUserId( Long.valueOf( id ) );
      return users;
  }

}
