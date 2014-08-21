/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.login;

import com.matsu.simplewebapp.dao.DBExecuteImpl;
import com.matsu.simplewebapp.user.UserData;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JP207528
 */
@RequestScoped
@Named
public class Login {
    
    private long id;
    
    private String password;
    
    @Inject
    private UserData userData;
    
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct");
    }
    
    public String login() {
       
        userData.setId(this.id);
        userData.setPassword(this.password);
        
        DBExecuteImpl.persistUserProfile(this.id, this.password);

        // URLを遷移先のもので表示させるためリダイレクトさせる
        return "enter.xhtml?faces-redirect=true";
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public UserData getUserData() {
        return userData;
    }

    public void setUserData(UserData userData) {
        this.userData = userData;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
