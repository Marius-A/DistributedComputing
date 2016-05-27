package com.mariusiliescu.model.entities;

/**
 * Created by Marius on 25.05.2016.
 * This class is used to store the authentification data for each client
 */
public class AuthentificationData {

    private String username;
    private String password;

    /**
     * General constructor
     * @param username
     * @param password
     */
    public AuthentificationData(String username, String password){
        this.username = username;
        this.password = password;
    }

    /**
     * Username Getter
     * @return the client usenrname
     */
    public String getUsername() {
        return username;
    }

    /**
     * Password Getter
     * @return the client Password
     */
    public String getPassword() {
        return password;
    }
}
