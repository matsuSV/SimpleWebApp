/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matsu.simplewebapp.content;

import com.matsu.simplewebapp.dao.UserProfileExecute;
import com.matsu.simplewebapp.entity.Class01Slope90;
import com.matsu.simplewebapp.user.Class01Data;
import com.matsu.simplewebapp.user.UserData;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JP207528
 */
@RequestScoped
@Named
public class RouteColor {
    
    private String selectedColor;
    
    private String selectedSlopes;
    
    private List<SelectItem> colors;
    
    private List<SelectItem> slopes;
    
    @Inject
    private UserData userData;
    
    @Inject
    private Class01Data class01Data;
    
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct RouteColor");
        
        List<SelectItem> icolors = new ArrayList<>();
        icolors.add(new SelectItem("green", "緑　"));
        icolors.add(new SelectItem("pink", "桃　"));
        icolors.add(new SelectItem("white", "白　"));
        icolors.add(new SelectItem("purple", "紫　"));
        this.colors = icolors;

        List<SelectItem> islopes = new ArrayList<>();
        islopes.add(new SelectItem("90", "90度　"));
        islopes.add(new SelectItem("110", "110度　"));
        islopes.add(new SelectItem("120", "120度　"));
        islopes.add(new SelectItem("monthly", "月間　"));
        this.slopes = islopes;
    }
    
    public String recode() {
        
        Long id = userData.getId();
        
        Class01Slope90 class01Slope90 = class01Data.getClass01Slope90();
        if( this.selectedColor.equals("green")) {
            class01Slope90.setGreen(new Date(System.currentTimeMillis()));
        }
        if( this.selectedColor.equals("pink")) {
            class01Slope90.setPink(new Date(System.currentTimeMillis()));
        }
        if( this.selectedColor.equals("white")) {
            class01Slope90.setWhite(new Date(System.currentTimeMillis()));
        }
        if( this.selectedColor.equals("purple")) {
            class01Slope90.setPurple(new Date(System.currentTimeMillis()));
        }
        
        if( this.selectedSlopes.equals("90") ) {
            
            System.out.println(id);
        
            UserProfileExecute dbei = new UserProfileExecute();
            dbei.updateClass01Slope90Recode(class01Slope90);
            dbei.closeResources();
        }
        
        // URLを遷移先のもので表示させるためリダイレクトさせる
        return "enter.xhtml?faces-redirect=true";
        
    }

    public String getSelectedColor() {
        return this.selectedColor;
    }

    public void setSelectedColor(String selectedColor) {
        this.selectedColor = selectedColor;
    }

    public List<SelectItem> getColors() {
        return this.colors;
    }

    public void setColors(List<SelectItem> colors) {
        this.colors = colors;
    }

    public List<SelectItem> getSlopes() {
        return this.slopes;
    }

    public void setSlopes(List<SelectItem> slopes) {
        this.slopes = slopes;
    }

    public String getSelectedSlopes() {
        return selectedSlopes;
    }

    public void setSelectedSlopes(String selectedSlopes) {
        this.selectedSlopes = selectedSlopes;
    }
    
    
}
