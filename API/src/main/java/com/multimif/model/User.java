package com.multimif.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Alexis on 17/10/2016.
 * Attention: Le nom de l'id de l'user doit être differente à 'id'
 */
@Entity
@NamedQueries({
        @NamedQuery(name="User.findByMail", query="SELECT u from User u WHERE u.mail = :mail"),
        @NamedQuery(name="User.findByUsername", query="SELECT u from User u WHERE u.username = :username"),
        @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
})
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "mail", unique = true, nullable = false)
    private String mail;

    @Column(name = "username", unique = true)
    private String username;

    @Column(length = 100, nullable = false)
    private String password;

    public User(){

    }

    public User(String mail, String username, String password) {
        this.username = username;
        this.mail = mail;
        this.password = password;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long id) {
        this.idUser = id;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String pseudo) {
        this.username = pseudo;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String hashkey) {
        this.password = hashkey;
    }

    public String getUsername() {
        return username;
    }

    public String getMail() {
        return mail;
    }
}