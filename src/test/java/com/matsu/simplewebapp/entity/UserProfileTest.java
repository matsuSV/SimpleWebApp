/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.entity;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author JP207528
 */
public class UserProfileTest {
    
    private static EntityManagerFactory emf;
    private static EntityManager em;
    private static EntityTransaction tx;
    
    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("com.matsu_SimpleWebApp_war_1.0-SNAPSHOTPU_test");
        em  = emf.createEntityManager();
    }
    
    @AfterClass
    public static void tearDownClass() {
        em.close();
        emf.close();
    }
    
    @Before
    public void setUp() {
        tx = em.getTransaction();
    }
    
    @After
    public void tearDown() {
    }

    // エラーが発生します。さーせん。
    @Test
    public void shouldCreateAUserProfile() {
        
        // UserProfileインスタンスを生成する
        UserProfile up = new UserProfile();
        
        up.setId(1122L);
        up.setPassword("fogefoge");
        
        // データベースにテストデータを永続化する
        tx.begin();
        em.persist(up);
        tx.commit();
        assertNotNull("ID should not be null", up.getId());
        
        // データベースからテストデータを取得する
        List<UserProfile> userProfiles = em.createNamedQuery("findAllUserProfiles").getResultList();
        assertEquals(1, userProfiles.size());
    }
    
}
