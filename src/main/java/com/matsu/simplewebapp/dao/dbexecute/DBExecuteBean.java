/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matsu.simplewebapp.dao.dbexecute;

import com.matsu.simplewebapp.dao.AbstractDBExecuteDao;
import com.matsu.simplewebapp.entity.UserProfile;
import com.matsu.simplewebapp.entity.interfaces.IRouteTask;

/**
 *
 * @author JP207528
 */
public class DBExecuteBean extends AbstractDBExecuteDao {
    
    public void persistUserProfile(Long id, String password) {
        
        UserProfile user = new UserProfile();
        user.setId(id);
        user.setPassword(password);
        
        super.tx.begin();
        super.em.persist(user);
        super.tx.commit();
    }
    
    public <T> T findById(Class<T> T, Long id) {
        super.tx.begin();
        T result = super.em.find(T, id);
        super.tx.commit();
        return (T) result;
    }
    
    public void insert(IRouteTask irouteTask) {
        super.tx.begin();
        super.em.merge(irouteTask);
        super.tx.commit();
    }
    
    public void update(IRouteTask irouteTask) {
        super.tx.begin();
        super.em.merge(irouteTask);
        super.tx.commit();
    }
}
