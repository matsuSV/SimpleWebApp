package com.matsu.simplewebapp.content;

import com.matsu.simplewebapp.entity.Class01Slope90;
import com.matsu.simplewebapp.user.Class01Data;
import com.matsu.simplewebapp.user.UserData;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * 
 * 
 * 
 * 
 */
@Named
public class Enter {
    
    private long id;

    private String password;
    
    private Class01Slope90 class01Slope90;
    
    @Inject
    private UserData userData;
    
    @Inject
    private Class01Data class01Data;
    
    public Enter() {
    }
    
    @PostConstruct
    public void init() {
        this.id = userData.getId();
        this.password = userData.getPassword();
        this.class01Slope90 = class01Data.getClass01Slope90();
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public UserData getUserData() {
        return userData;
    }
    public void setUserData(UserData userData) {
        this.userData = userData;
    }
    public Class01Data getClass01Data() {
        return class01Data;
    }
    public void setClass01Data(Class01Data class01Data) {
        this.class01Data = class01Data;
    }
    public Class01Slope90 getClass01Slope90() {
        return this.class01Slope90;
    }
    public void setClass01Slope90(Class01Slope90 class01Slope90) {
        this.class01Slope90 = class01Slope90;
    }
}
