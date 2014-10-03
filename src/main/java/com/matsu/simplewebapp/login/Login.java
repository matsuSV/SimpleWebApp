package com.matsu.simplewebapp.login;

import com.matsu.simplewebapp.dao.UserProfileExecute;
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
       
        userData.setId(this.id);
        userData.setPassword(this.password);

        UserProfileExecute dbei = new UserProfileExecute();
        
        UserProfile userProfile = dbei.findUserProfileById(this.id);
        if( null == userProfile ) {
            // 登録がないユーザー
            dbei.closeResources();
            return "register.xhtml?faces-redirect=true";
        }
        
        class01Data.setClass01Slope90(dbei.findClass01ById(this.id));
        dbei.closeResources();

        // URLを遷移先のもので表示させるためリダイレクトさせる
        return "enter.xhtml?faces-redirect=true";
    }
    
    public String register() {
        UserProfileExecute dbei = new UserProfileExecute();
        dbei.persistUserProfile(this.id, this.password);
        dbei.insertInitClass01Slope90(this.id);
        dbei.closeResources();
        
        // URLを遷移先のもので表示させるためリダイレクトさせる
        return "login.xhtml?faces-redirect=true";
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
