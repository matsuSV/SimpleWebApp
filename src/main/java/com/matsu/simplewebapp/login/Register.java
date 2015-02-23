/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matsu.simplewebapp.login;

import com.matsu.simplewebapp.dao.dbexecute.DBExecuteBean;
import com.matsu.simplewebapp.entity.Class01Slope90;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 */
@RequestScoped
@Named
public class Register {
    
    private long id;
    
    private String password;
    
    public String register() {
        
        DBExecuteBean executer = new DBExecuteBean();
        executer.persistUserProfile(this.id, this.password);
        
        Class01Slope90 c01s90 = new Class01Slope90();
        c01s90.setId(this.id);
        executer.insert(c01s90);

        executer.closeResources(); // エラーが発生した場合はロールバックして2つのデータを戻す必要がある。
        
        // URLを遷移先のもので表示させるためリダイレクトさせる
        return "login.xhtml?faces-redirect=true";
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
