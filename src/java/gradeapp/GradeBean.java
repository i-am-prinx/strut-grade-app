/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradeapp;

import org.apache.struts.action.ActionForm;

/**
 *
 * @author i-am-prinx
 */
public class GradeBean extends ActionForm {
    
    String name, english, math, science, language;
    
    public GradeBean (){
        super();
    }
    
    
    public String getName( ){
        return name;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getEnglish( ){
        return english;
    }
    
    public void setEnglish(String english){
        this.english = english;
    }
    
    public String getMath( ){
        return math;
    }
    
    public void setMath(String math){
        this.math = math;
    }
    
    public String getScience( ){
        return science;
    }
    
    public void setScience(String science){
        this.science = science;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public void setLanguage(String language){
        this.language = language;
    }
}
