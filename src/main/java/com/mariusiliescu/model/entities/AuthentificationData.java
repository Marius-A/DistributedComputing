package com.mariusiliescu.model.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * Created by Marius on 25.05.2016.
 * This class is used to store the authentification data for each client
 */
@Entity
public class AuthentificationData {

    @Id
    private String username;

    @NotEmpty
    @NotNull
    @Column(unique = true)
    private String eMail;

    @NotEmpty
    @NotNull
    private String password;

    /**
     * General constructor
     *
     * @param username
     * @param password
     */
    public AuthentificationData(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /**
     * Username Getter
     *
     * @return the client usenrname
     */
    public String getUsername() {
        return username;
    }

    /**
     * Password Getter
     *
     * @return the client Password
     */
    public String getPassword() {
        return password;
    }
}
