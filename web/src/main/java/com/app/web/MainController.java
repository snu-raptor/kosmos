package com.app.web;

import com.app.dao.ArticleDao;
import com.app.dao.CommentDao;
import com.app.dao.UserDao;
import com.app.model.Article;
import com.app.model.Comment;
import com.app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
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
  @Autowired
  private CommentDao commentDao;

  @Autowired
  private ArticleDao articleDao;

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public List<User> test( @PathVariable("id") String id )
  {
    User user = new User()
      .setConfirmed( true )
      .setEmail( "lol" )
      .setLocked( true )
      .setLogin( "login" )
      .setPassword( "lol" )
      .setPathToAvatar( "true" )
      .setRegistrationDate( LocalDate.now() )
      .setRole( "string" )
      .setLastVisit( LocalDate.now() );

//    List<User> users = userDao.findByUserId( Long.valueOf( id ) );

    User user2 = new User()
      .setConfirmed( true )
      .setEmail( "email2" )
      .setLastVisit( LocalDate.now() )
      .setLocked( false )
      .setLogin( "login2" )
      .setPassword( "password2" )
      .setPathToAvatar( "path2" )
      .setRegistrationDate( LocalDate.now() )
      .setRole( "ROLE2" );

    Comment comment = new Comment( "text", LocalDate.now(), true );
    Comment comment2 = new Comment( "text2", LocalDate.now(), false );
    Comment comment3 = new Comment( "text3", LocalDate.now(), true );
    Comment comment4 = new Comment( "text4", LocalDate.now(), false );

    Article article = new Article()
      .setHeader( "header" )
      .setDate( LocalDate.now() )
      .setText( "text" )
      .setChecked( true )
      .setComments( comment )
      .setComments( comment3 )
      .setUser( user );

    Article article2 = new Article()
      .setHeader( "header2" )
      .setDate( LocalDate.now() )
      .setText( "text2" )
      .setChecked( true )
      .setComments( comment2 )
      .setComments( comment4 )
      .setUser( user );


    user.setArticles( article );
    user.setArticles( article2 );
/*
    user.setComment( comment3 );
    user.setComment( comment4 );

    user2.setComment( comment );
    user2.setComment( comment2 );
*/
    userDao.save( user );
    userDao.save( user2 );

    commentDao.save( comment );
    commentDao.save( comment2 );
    commentDao.save( comment3 );
    commentDao.save( comment4 );

    articleDao.save( article );
    articleDao.save( article2 );

    userDao.delete( 2L );
    return null;
  }
}