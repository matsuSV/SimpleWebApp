package com.matsu.simplewebapp.dao;

import com.matsu.simplewebapp.entity.Class01Slope90;
import com.matsu.simplewebapp.entity.UserProfile;

/**
 *
 * @author JP207528
 */
public class UserProfileExecute extends AbstractDBExecute {
    
    public void persistUserProfile(Long id, String password) {
        
        UserProfile user = new UserProfile();
        user.setId(id);
        user.setPassword(password);
        
        super.tx.begin();
        super.em.persist(user);
        super.tx.commit();

    }
    
    public UserProfile findUserProfileById(Long id) {
        super.tx.begin();
        UserProfile result = super.em.find(UserProfile.class, id);
        super.tx.commit();
        return result;
    }
    
    public Class01Slope90 findClass01ById(Long id) {
        super.tx.begin();
        Class01Slope90 result = super.em.find(Class01Slope90.class, id);
        super.tx.commit();
        return result;
    }
    
    public void insertInitClass01Slope90(Long id) {
        String sql = "insert into Class01Slope90 (id) values (" + id + ")";
        
        Class01Slope90 class01Slope90 = new Class01Slope90();
        class01Slope90.setId(id);
        
        super.tx.begin();
        super.em.persist(class01Slope90);
        super.tx.commit();
    }
    
    public void updateClass01Slope90Recode(Class01Slope90 class01Slope90) {
        super.tx.begin();
        super.em.merge(class01Slope90);
        super.tx.commit();
    }
}
