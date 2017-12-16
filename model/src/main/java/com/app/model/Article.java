package com.app.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author Viktar Kolbik
 * @since 12/16/17
 */

@Entity
@Table(name = "Article")
@DynamicInsert
@DynamicUpdate
public class Article
{
  @Id
  @Column(name = "articleId")
  @GeneratedValue
  private int articleId;

  @Column(name = "header", unique = true, nullable = false)
  private String header;

  @Column(name = "text", unique = true, nullable = false, length = 1000)
  private String text;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Column(name = "isChecked", nullable = false)
  private boolean isChecked;

  @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
  private Set<Comment> comments;

  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  public Article() {
  }

  public int getArticleId()
  {
    return articleId;
  }

  public Article setArticleId( int articleId )
  {
    this.articleId = articleId;
    return this;
  }

  public String getHeader()
  {
    return header;
  }

  public Article setHeader( String header )
  {
    this.header = header;
    return this;
  }

  public String getText()
  {
    return text;
  }

  public Article setText( String text )
  {
    this.text = text;
    return this;
  }

  public LocalDate getDate()
  {
    return date;
  }

  public Article setDate( LocalDate date )
  {
    this.date = date;
    return this;
  }

  public boolean isChecked()
  {
    return isChecked;
  }

  public Article setChecked( boolean checked )
  {
    isChecked = checked;
    return this;
  }

  public Set<Comment> getComments()
  {
    return comments;
  }

  public Article setComments( Set<Comment> comments )
  {
    this.comments = comments;
    return this;
  }

  public User getUser()
  {
    return user;
  }

  public Article setUser( User user )
  {
    this.user = user;
    return this;
  }

}
