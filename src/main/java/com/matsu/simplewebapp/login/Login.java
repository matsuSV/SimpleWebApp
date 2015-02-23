package com.matsu.simplewebapp.login;

import com.matsu.simplewebapp.dao.dbexecute.DBExecuteBean;
import com.matsu.simplewebapp.entity.Class01Slope90;
import com.matsu.simplewebapp.entity.UserProfile;
import com.matsu.simplewebapp.user.Class01Data;
import com.matsu.simplewebapp.user.UserData;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * 
 */
@RequestScoped
@Named
public class Login {
    
    private long id;
    
    private String password;
    
    @Inject
    private UserData userData;
    
    @Inject
    private Class01Data class01Data;
    
    public String login() {
        if( hasUserProfile() ) {
            DBExecuteBean executer        = new DBExecuteBean();
            Class01Slope90 class01Slope90 = executer.findById(Class01Slope90.class, this.id);
            class01Data.setClass01Slope90(class01Slope90);
            executer.closeResources();
            
            setUserData();
            
            // URLを遷移先のもので表示させるためリダイレクトさせる
            return "enter.xhtml?faces-redirect=true";
        }
        return "register.xhtml?faces-redirect=true";
    }
    
    private boolean hasUserProfile() {
        DBExecuteBean executer  = new DBExecuteBean();
        UserProfile userProfile = executer.findById(UserProfile.class, this.id);
        executer.closeResources();
        if( null == userProfile ) { // 登録がないユーザー
            return false;
        }
        return true;
    }
    
    private void setUserData() {
        userData.setId(this.id);
        userData.setPassword(this.password);
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
    public Class01Data getClass01Data() {
        return class01Data;
    }
    public void setClass01Data(Class01Data class01Data) {
        this.class01Data = class01Data;
    }
}
