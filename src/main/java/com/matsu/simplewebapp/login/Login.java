/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.login;

import com.matsu.simplewebapp.user.UserFolder;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JP207528
 */
@Named
public class Login {
    
    private long id;
    
    private String password;
    
    @Inject
    private UserFolder userfolder;
    
       
    public String login() {
        
                System.out.println("Start id = " + this.id);
        System.out.println("Start password = " + this.password);
        
        userfolder.setId(this.id);
        userfolder.setPassword(this.password);
        
        System.out.println("Login id = " + userfolder.getId());
        System.out.println("Login password = " + userfolder.getPassword());
        
        // URLを遷移先のもので表示させるためリダイレクトさせる
        return "enter.xhtml?faces-redirect=true";
    }

    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
