/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.matsu.simplewebapp.user;

import com.matsu.simplewebapp.entity.Class01Slope90;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author JP207528
 */
@SessionScoped
@Named
public class Class01Data implements Serializable {
    
    private Class01Slope90 class01Slope90;

    public Class01Slope90 getClass01Slope90() {
        return class01Slope90;
    }
    public void setClass01Slope90(Class01Slope90 class01Slope90) {
        this.class01Slope90 = class01Slope90;
    }
}
