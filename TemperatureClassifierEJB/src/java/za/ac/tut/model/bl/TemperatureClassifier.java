/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.model.bl;

import javax.ejb.Stateless;

/**
 *
 * @author USER
 */
@Stateless
public class TemperatureClassifier implements TemperatureClassifierLocal {

    @Override
    public String classifyTemperature(Double temp) {
        String outcome = "High";
        
        if(temp <= 38){
            outcome = "Low";
        }
        
        return outcome;
    }

    @Override
    public String advice(String category) {
        String advice = "Normal temperature. Keep it up!";
        
        if(category.equals("High")){
            advice = "You're at risk consult a Doctor.";
        }
        
        return advice;
    }

    
}
