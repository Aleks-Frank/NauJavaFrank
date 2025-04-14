package ru.AlexFrank.LibraryWeb.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tbl_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    private String nameUser;

    private String surnameUser;

    private String patronymicUser;

    private String role;

    private String login;

    private String password;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getSurnameUser() {
        return surnameUser;
    }

    public void setSurnameUser(String surnameUser) {
        this.surnameUser = surnameUser;
    }

    public String getPatronymicUser() {
        return patronymicUser;
    }

    public void setPatronymicUser(String patronymicUser) {
        this.patronymicUser = patronymicUser;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String nameUser, String surnameUser, String patronymicUser, String role, String login, String password) {
        this.nameUser = nameUser;
        this.surnameUser = surnameUser;
        this.patronymicUser = patronymicUser;
        this.role = role;
        this.login = login;
        this.password = password;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "nameUser='" + nameUser + '\'' +
                ", surnameUser='" + surnameUser + '\'' +
                ", patronymicUser='" + patronymicUser + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
