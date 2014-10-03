package com.matsu.simplewebapp.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * 
 * 
 */
@Entity
@NamedQuery(name = "findAllUserProfiles", query = "SELECT b FROM UserProfile b")
public class UserProfile implements Serializable {
    
    @Id
    private long id;
    
    @Column(nullable = false)
    private String password;
    
    private String name;

    public UserProfile() {
    }

    public long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}