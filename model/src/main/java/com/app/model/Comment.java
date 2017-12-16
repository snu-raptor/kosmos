package com.app.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDate;

/**
 * @author Viktar Kolbik
 * @since 12/16/17
 */
@Table
@DynamicInsert
@DynamicUpdate
public class Comment
{

  @Id
  @Column
  @GeneratedValue
  private int commentId;

  @Column( length = 1500, nullable = false)
  private String text;

  @Column( nullable = false)
  private LocalDate date;

  @Column( nullable = false)
  private boolean isHidden;

  @ManyToOne(targetEntity = User.class)
  @JoinColumn(name = "userId", nullable = false)
  private User user;

  public Comment() {
  }

  public Comment(String text, LocalDate date, boolean isHidden) {
    this.text = text;
    this.date = date;
    this.isHidden = isHidden;
  }

  public int getCommentId() {
    return commentId;
  }

  public Comment setCommentId(int commentId) {
    this.commentId = commentId;
    return this;
  }

  public String getText() {
    return text;
  }

  public Comment setText(String text) {
    this.text = text;
    return this;
  }

  public LocalDate getDate() {
    return date;
  }

  public Comment setDate(LocalDate date) {
    this.date = date;
    return this;
  }

  public boolean isHidden() {
    return isHidden;
  }

  public Comment setHidden(boolean hidden) {
    isHidden = hidden;
    return this;
  }

  public User getUser() {
    return user;
  }

  public Comment setUser(User user) {
    this.user = user;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Comment comment = (Comment) o;

    if (commentId != comment.commentId) return false;
    if (isHidden != comment.isHidden) return false;
    if (!text.equals(comment.text)) return false;
    return date.equals(comment.date);
  }

  @Override
  public int hashCode() {
    int result = commentId;
    result = 13 * result + text.hashCode();
    result = 14 * result + date.hashCode();
    result = 15 * result + (isHidden ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Comment{" +
      "commentId=" + commentId +
      ", text='" + text + '\'' +
      ", date=" + date +
      ", isHidden=" + isHidden +
      '}';
  }
}
