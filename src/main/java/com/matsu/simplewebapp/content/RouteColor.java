/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.matsu.simplewebapp.content;

import com.matsu.simplewebapp.dao.dbexecute.DBExecuteBean;
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
    
    private String selectedLevel;
    
    private String selectedColor;
    
    private String selectedSlopes;
    
    private List<SelectItem> levels;
    
    private List<SelectItem> colors;
    
    private List<SelectItem> slopes;
    
    @Inject
    private UserData userData;
    
    @Inject
    private Class01Data class01Data;
    
    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct RouteColor");
        
        List<SelectItem> ilevels = new ArrayList<>();
        ilevels.add(new SelectItem("1grade", "初段　"));
        ilevels.add(new SelectItem("1class", "1級　"));
        ilevels.add(new SelectItem("2class", "2級　"));
        ilevels.add(new SelectItem("3class", "3級　"));
        this.levels = ilevels;
        
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
        
            DBExecuteBean c01s90 = new DBExecuteBean();

            c01s90.update(class01Slope90);
            c01s90.closeResources();
        }
        
        // URLを遷移先のもので表示させるためリダイレクトさせる
        return "enter.xhtml?faces-redirect=true";
        
    }

    public String getSelectedLevel() {
        return selectedLevel;
    }

    public void setSelectedLevel(String selectedLevel) {
        this.selectedLevel = selectedLevel;
    }

    public List<SelectItem> getLevels() {
        return levels;
    }

    public void setLevels(List<SelectItem> levels) {
        this.levels = levels;
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
