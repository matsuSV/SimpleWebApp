/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 *
 * @author JP207528
 */
public abstract class AbstractDBExecuteDao {
    
        protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.matsu_SimpleWebApp_war_1.0-SNAPSHOTPU");
        protected EntityManager         em = emf.createEntityManager();
        protected EntityTransaction     tx = em.getTransaction();
        
        public void closeResources() {
            this.em.close();
            this.emf.close();
        } 
}
