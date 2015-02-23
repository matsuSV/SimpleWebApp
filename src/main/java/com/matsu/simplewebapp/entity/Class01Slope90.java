/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.entity;

import com.matsu.simplewebapp.entity.interfaces.IRouteTask;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author JP207528
 */
@Entity
public class Class01Slope90 implements Serializable, IRouteTask {
    
    @Id
    private Long id;
    
    private Date green;
    
    private Date pink;
    
    private Date white;
    
    private Date purple;
    
    public Class01Slope90() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getGreen() {
        return green;
    }

    public void setGreen(Date green) {
        this.green = green;
    }

    public Date getPink() {
        return pink;
    }

    public void setPink(Date pink) {
        this.pink = pink;
    }

    public Date getWhite() {
        return white;
    }

    public void setWhite(Date white) {
        this.white = white;
    }

    public Date getPurple() {
        return purple;
    }

    public void setPurple(Date purple) {
        this.purple = purple;
    }
    
}
