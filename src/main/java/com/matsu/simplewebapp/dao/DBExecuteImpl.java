/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.dao;

import com.matsu.simplewebapp.entity.Class01Slope90;
import com.matsu.simplewebapp.entity.UserProfile;

/**
 *
 * @author JP207528
 */
public class DBExecuteImpl extends AbstractDBExecute {
    
    public void persistUserProfile(Long id, String password) {
        
        UserProfile user = new UserProfile();
        user.setId(id);
        user.setPassword(password);
        
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.matsu_SimpleWebApp_war_1.0-SNAPSHOTPU");
//        EntityManager         em = emf.createEntityManager();
//        EntityTransaction     tx = em.getTransaction();
        
        super.tx.begin();
        super.em.persist(user);
        super.tx.commit();

    }
    
    public Class01Slope90 findClass01ById(Long id) {
        
        super.tx.begin();
        Class01Slope90 result = super.em.find(Class01Slope90.class, id);
        super.tx.commit();
        
        return result;
    }
}
