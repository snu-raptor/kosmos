package com.app.model;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Viktor
 * @since 6/16/17
 */
@Entity
@Table
@DynamicInsert
@DynamicUpdate
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(nullable = false, unique = true, length = 100)
    private String login;

    @Column( nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 25)
    private String password;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false)
    private boolean isLocked;

    @Column(nullable = false)
    private boolean isConfirmed;

    @Column(nullable = false, length = 50)
    private String role;

    @Column( nullable = false)
    private LocalDate lastVisit;

    /**
     * if there is no avatar, we use default one;
     */
    @Column( nullable = false, length = 2048)
    private String pathToAvatar;

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<Comment>();

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public User setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public User setLogin(String login) {
        this.login = login;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public User setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
        return this;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public User setLocked(boolean locked) {
        isLocked = locked;
        return this;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public User setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
        return this;
    }

    public String getRole() {
        return role;
    }

    public User setRole(String role) {
        this.role = role;
        return this;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public User setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
        return this;
    }

    public String getPathToAvatar() {
        return pathToAvatar;
    }

    public User setPathToAvatar(String pathToAvatar) {
        this.pathToAvatar = pathToAvatar;
        return this;
    }


    public Set<Comment> getComments() {
        return comments;
    }

    public User setComment(Comment comment) {
        comment.setUser(this);
        this.comments.add(comment);
        return this;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId) return false;
        if (isLocked != user.isLocked) return false;
        if (isConfirmed != user.isConfirmed) return false;
        if (!login.equals(user.login)) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;
        if (!registrationDate.equals(user.registrationDate)) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (lastVisit != null ? !lastVisit.equals(user.lastVisit) : user.lastVisit != null) return false;
        return pathToAvatar != null ? pathToAvatar.equals(user.pathToAvatar) : user.pathToAvatar == null;
    }

    @Override
    public int hashCode() {
        int result = userId.intValue();
        result = 113 * result + login.hashCode();
        result = 2 * result + email.hashCode();
        result = 3 * result + password.hashCode();
        result = 6 * result + registrationDate.hashCode();
        result = 7 * result + (isLocked ? 1 : 0);
        result = 8 * result + (isConfirmed ? 1 : 0);
        result = 9 * result + (role != null ? role.hashCode() : 0);
        result = 11 * result + (lastVisit != null ? lastVisit.hashCode() : 0);
        result = 12 * result + (pathToAvatar != null ? pathToAvatar.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
          "userId=" + userId +
          ", userName='" + login + '\'' +
          ", email='" + email + '\'' +
          ", password='" + password + '\'' +
          ", registrationDate=" + registrationDate +
          ", isLocked=" + isLocked +
          ", isConfirmed=" + isConfirmed +
          ", role='" + role + '\'' +
          ", lastVisit=" + lastVisit +
          ", pathToAvatar='" + pathToAvatar + '\'' +
          '}';
    }
}