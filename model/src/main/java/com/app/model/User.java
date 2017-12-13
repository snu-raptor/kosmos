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
    private Integer userId;

    @Column(nullable = false, unique = true, length = 100)
    private String login;

    @Column( nullable = false, unique = true, length = 50)
    private String email;

    @Column(nullable = false, length = 25)
    private String password;

    @Column(length = 50)
    private String firstName;

    @Column(length = 50)
    private String lastName;

    @Column(nullable = false)
    private LocalDate registrationDate;

    @Column(nullable = false)
    private boolean isLocked;

    @Column(nullable = false)
    private boolean isConfirmed;

    @Column(nullable = false, length = 50)
    private String role;

    @Column
    private LocalDate birthDay;

    @Column( nullable = false)
    private LocalDate lastVisit;

    /**
     * if there is no avatar, we use default one;
     */
    @Column( nullable = false, length = 2048)
    private String pathToAvatar;
/*
    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Recipe> recipe = new HashSet<>();

    @OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
    */
    public User() {
    }

    /**
     *  Constructor with required fields
     */
    public User(String login, String email, String password, LocalDate registrationDate,
      boolean isLocked, boolean isConfirmed, String role, LocalDate lastVisit,
      String pathToAvatar) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.registrationDate = registrationDate;
        this.isLocked = isLocked;
        this.isConfirmed = isConfirmed;
        this.role = role;
        this.lastVisit = lastVisit;
        this.pathToAvatar = pathToAvatar;
    }

    public User(String login, String email, String password, String firstName, String lastName,
      LocalDate registrationDate, boolean isLocked, boolean isConfirmed, String role,
      LocalDate birthDay, LocalDate lastVisit, String pathToAvatar) {
        this.login = login;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.registrationDate = registrationDate;
        this.isLocked = isLocked;
        this.isConfirmed = isConfirmed;
        this.role = role;
        this.birthDay = birthDay;
        this.lastVisit = lastVisit;
        this.pathToAvatar = pathToAvatar;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean isConfirmed() {
        return isConfirmed;
    }

    public void setConfirmed(boolean confirmed) {
        isConfirmed = confirmed;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getPathToAvatar() {
        return pathToAvatar;
    }

    public void setPathToAvatar(String pathToAvatar) {
        this.pathToAvatar = pathToAvatar;
    }
/*

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComment(Comment comment) {
        comment.setUser(this);
        this.comments.add(comment);
    }

    public Set<Recipe> getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        recipe.setUser(this);
        this.recipe.add(recipe);
    }
*/

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
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (!registrationDate.equals(user.registrationDate)) return false;
        if (role != null ? !role.equals(user.role) : user.role != null) return false;
        if (birthDay != null ? !birthDay.equals(user.birthDay) : user.birthDay != null) return false;
        if (lastVisit != null ? !lastVisit.equals(user.lastVisit) : user.lastVisit != null) return false;
        return pathToAvatar != null ? pathToAvatar.equals(user.pathToAvatar) : user.pathToAvatar == null;
    }

    @Override
    public int hashCode() {
        int result = userId;
        result = 113 * result + login.hashCode();
        result = 2 * result + email.hashCode();
        result = 3 * result + password.hashCode();
        result = 4 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 5 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 6 * result + registrationDate.hashCode();
        result = 7 * result + (isLocked ? 1 : 0);
        result = 8 * result + (isConfirmed ? 1 : 0);
        result = 9 * result + (role != null ? role.hashCode() : 0);
        result = 10 * result + (birthDay != null ? birthDay.hashCode() : 0);
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
          ", firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          ", registrationDate=" + registrationDate +
          ", isLocked=" + isLocked +
          ", isConfirmed=" + isConfirmed +
          ", role='" + role + '\'' +
          ", birthDay=" + birthDay +
          ", lastVisit=" + lastVisit +
          ", pathToAvatar='" + pathToAvatar + '\'' +
          '}';
    }
}
