/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.content;

import com.matsu.simplewebapp.user.UserFolder;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JP207528
 */
@Named
public class Enter {
    
    private long id;

    private String password;
    
    @Inject
    private UserFolder userfolder;
    
    public Enter() {
//        this.id = userfolder.getId();
//        this.password = userfolder.getPassword();
//        this.id = 9999;
//        this.password = "dummy";
    }
    
    @PostConstruct
    public void init() {
        this.id = userfolder.getId();
        this.password = userfolder.getPassword();
        
        System.out.println("id = " + userfolder.getId());
        System.out.println("password = " + userfolder.getPassword());
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
}
