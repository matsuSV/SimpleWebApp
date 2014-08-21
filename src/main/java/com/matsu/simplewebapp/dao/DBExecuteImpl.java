/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.dao;

import com.matsu.simplewebapp.entity.UserProfile;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author JP207528
 */
public class DBExecuteImpl {
    
    public static void persistUserProfile(Long id, String password) {
        
        UserProfile user = new UserProfile();
        user.setId(id);
        user.setPassword(password);
        
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.matsu_SimpleWebApp_war_1.0-SNAPSHOTPU");
        EntityManager         em = emf.createEntityManager();
        EntityTransaction     tx = em.getTransaction();
        
        
        tx.begin();
        em.persist(user);
        tx.commit();
        
        em.close();
        emf.close();
        
    }
}
