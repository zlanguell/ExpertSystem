/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystemv2;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Zachary
 */
public class ForwardChainKB {

    //Maximum number of rules
    private static final int NUM_OF_RULES = 25;
    
    //Maximum number of antecendents per conclusion
    private static final int NUM_OF_VAR_PER_RULE = 2;
    
    //Clause Variable List
    private String[] clauseVariableList = new String[NUM_OF_RULES * NUM_OF_VAR_PER_RULE];
    
    //Variable List
    private final Map<String, String> variableList = new HashMap<>();
    
    //Constructor

    /**
     *
     */
    public ForwardChainKB(){
        //Populate Clause Variable List
        //rule 1
        clauseVariableList[1] = "fault";
        //rule 2
        clauseVariableList[3] = "fault";
        
        //Populate Variable List
        variableList.put("fault", "none");
        variableList.put("solution","none");
    }
    //Rule List

    /**
     *
     * @param ruleNumber
     */
    public void evaluateRule(int ruleNumber){
        switch(ruleNumber){
            case 10:
                if(variableList.get("fault").compareTo("None")==0){
                    variableList.replace("solution", "No fault requires no solution.");
                }
                break;
            case 20:
                if(variableList.get("fault").compareTo("Gas")==0){
                    variableList.replace("solution", "Fill the vehicle up with fuel.");
                }
                break;
            case 30:
                if(variableList.get("fault").compareTo("Battery")==0){
                    variableList.replace("solution", "Charge the vehicle battery.");
                }
                break;
            case 40:
                if(variableList.get("fault").compareTo("Fuse")==0){
                    variableList.replace("solution", "Replace the blown fuse.");
                }
                break;
            case 50:
                if(variableList.get("fault").compareTo("Bulb")==0){
                    variableList.replace("solution", "Replace the light bulb.");
                }
                break;
            case 60:
                if(variableList.get("fault").compareTo("Starter")==0){
                    variableList.replace("solution", "Replace the vehicle's starter.");
                }
                break; 
            case 70:
                if(variableList.get("fault").compareTo("FuelPump")==0){
                    variableList.replace("solution", "Replace the vehicle fuel pump.");
                }
                break;
            case 80:
                if(variableList.get("fault").compareTo("Transmission")==0){
                    variableList.replace("solution", "The vehicle transmission needs repaired.");
                }
                break;
            case 90:
                if(variableList.get("fault").compareTo("Muffler")==0){
                    variableList.replace("solution", "Replace the muffler to stop the noise.");
                }
                break;
            case 100:
                if(variableList.get("fault").compareTo("BrakePad")==0){
                    variableList.replace("solution", "Replace the brake pads to stop the noise.");
                }
                break;
            case 110:
                if(variableList.get("fault").compareTo("BrakeFluid")==0){
                    variableList.replace("solution", "Top off the brake fluid to correct the fault.");
                }
                break;
            case 120:
                if(variableList.get("fault").compareTo("Flat")==0){
                    variableList.replace("solution", "Replace the flat tire.");
                }
                break;
            case 130:
                if(variableList.get("fault").compareTo("Alignment")==0){
                    variableList.replace("solution", "Align the tires.");
                }
                break;
            case 140:
                if(variableList.get("fault").compareTo("CatConv")==0){
                    variableList.replace("solution", "Replace the catalytic converter.");
                }
                break;
            case 150:
                if(variableList.get("fault").compareTo("OilLeak")==0){
                    variableList.replace("solution", 
                            "Locate the oil leak and replace that component to stop the black smoke.");
                }
                break;
            case 160:
                if(variableList.get("fault").compareTo("Radiator")==0){
                    variableList.replace("solution", "Replace or repair the radiator.");
                }
                break;
            case 170:
                if(variableList.get("fault").compareTo("Freon")==0){
                    variableList.replace("solution", "Refill the freon in the ac unit.");
                }
                break;
            case 180:
                if(variableList.get("fault").compareTo("Coolant")==0){
                    variableList.replace("solution", "Refill the vehicle coolant in the radiator.");
                }
                break;
            case 190:
                if(variableList.get("fault").compareTo("Unknown")==0){
                    variableList.replace("solution", "Unable to identify the fault / Unable to provide solution.");
                }
                break;
        }
    }
}
