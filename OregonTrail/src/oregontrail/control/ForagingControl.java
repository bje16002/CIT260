/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oregontrail.control;

import oregontrail.model.Player;

/**
 *
 * @author mellissah.
 */
public class ForagingControl {
    
    public void averageHealth() {
        int[] strengthValue = new int[4];
        
    }
    //function signature with parameter array variables
    public void getStrengthValue() {
        
        //initializing and defining one dimensional array
        int[] values = {1,2,3,4};
        
        //referencing elements items in an array
        int poor = values[1]; //get first element in array
        int fair = values[2]; //get second element in array
        int good = values[3]; //get third element in array
        int great = values[4]; //get fourth element in array
        
        
        int total = 0; //initialize total to zero
        int i;
        //navigate a one dimensional array using a for loop with index to find average health strength
        for (i = 0; i < values.length; i++) {
            total += values[i];
        }
        int avg = total / values.length;
    }
}
