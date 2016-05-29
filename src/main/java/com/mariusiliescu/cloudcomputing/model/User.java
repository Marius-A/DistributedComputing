package com.mariusiliescu.cloudcomputing.model;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull@NotEmpty
    @Column(unique = true)
    private String username;

    @NotNull@NotEmpty
    @Column(unique = true)
    private String email;

    @NotNull@NotEmpty
    private String password;

    @Transient
    private String passwordConfirm;

    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @OneToMany(mappedBy = "resolver")
    private Set<Task> resolvedTaskList;

    @OneToMany(mappedBy = "owner")
    private Set<Task> myTaskList;



    /**
     * User id getter
     * @return user id
     */
    public Long getId() {
        return id;
    }

    /**
     * User id setter
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * User username getter
     * @return user username
     */
    public String getUsername() {
        return username;
    }

    /**
     * User username setter
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * User email getter
     * @return user email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * User email setter
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * User password getter
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * User password setter
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * User password confirmation getter
     * @return
     */
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    /**
     * User password confirmation setter
     * @param passwordConfirm
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    /**
     * User roles getter
     * @return user roles
     */
    public Set<Role> getRoles() {
        return roles;
    }

    /**
     * User roles setter
     * @param roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * User resolved task list getter
     * @return user resolved task list
     */
    public Set<Task> getResolvedTaskList() {
        return resolvedTaskList;
    }

    /**
     * User resolved task list setter
     * @param resolvedTaskList
     */
    public void setResolvedTaskList(Set<Task> resolvedTaskList) {
        this.resolvedTaskList = resolvedTaskList;
    }

    /**
     * User tasklist , to be resolved getter
     * @return User tasklist , to be resolved
     */
    public Set<Task> getMyTaskList() {
        return myTaskList;
    }

    /**
     * User tasklist , to be resolved setter
     * @param myTaskList
     */
    public void setMyTaskList(Set<Task> myTaskList) {
        this.myTaskList = myTaskList;
    }
}
