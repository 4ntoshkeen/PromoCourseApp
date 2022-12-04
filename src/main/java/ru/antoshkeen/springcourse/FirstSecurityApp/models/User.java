package ru.antoshkeen.springcourse.FirstSecurityApp.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Column(name = "role")
    private String role;

    @NotEmpty
    @Column(name = "username")
    @Size(min = 2, max = 100, message = "Name should have more than 2 symbols")
    private String username;

    @Column(name = "year")
    @Min(value = 1900, message = "Year should have its value with more than 1900")
    private int year;

    @Column(name = "password")
    private String password;

    public User(String username, int year, String password, String role) {
        //this.id = id;
        this.username = username;
        this.year = year;
        this.password = password;
        this.role = role;
    }

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", year=" + year +
                ", password='" + password + '\'' +
                '}';
    }
}
