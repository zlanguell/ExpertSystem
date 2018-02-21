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
    static final int NUM_OF_RULES = 9;

    //Maximum number of antecendents per conclusion
    private static final int NUM_OF_VAR_PER_RULE = 2;
    
    //Goal of KB
    private String goal = "solution";
    
    //Clause Variable List
    private String[] clauseVariableList = new String[(NUM_OF_RULES * NUM_OF_VAR_PER_RULE)+1];

    //Variable List
    private final Map<String, String> variableList = new HashMap<>();

    //Constructor
    /**
     *
     */
    public ForwardChainKB() {
        //Populate Clause Variable List
        //rule 1
        clauseVariableList[1] = "fault";
        //rule 2
        clauseVariableList[3] = "fault";
        //rule 3
        clauseVariableList[5] = "fault";
        //rule 4
        clauseVariableList[7] = "fault";
        //rule 5
        clauseVariableList[9] = "fault";
        //rule 6
        clauseVariableList[11] = "fault";
        //rule 7
        clauseVariableList[13] = "fault";
        //rule 8
        clauseVariableList[15] = "fault";
        //rule 9
        clauseVariableList[17] = "fault";        

        //Populate Variable List
        variableList.put("fault", "none");
        variableList.put("solution", "none");
    }
    //Rule List
    
    public void setVariable(String key, String value){
      variableList.replace(key, value);
    }
    /**
     *
     * @param ruleNumber
     */
    public void evaluateRule(int ruleNumber) {
        ruleNumber = ((ruleNumber/2)+1)*10;
        switch (ruleNumber) {
            case 10:
                if (variableList.get("fault").compareTo("None") == 0) {
                    variableList.replace("solution", "No fault requires no solution.");
                }
                break;            
            case 20:
                if (variableList.get("fault").compareTo("Flat") == 0) {
                    variableList.replace("solution", "Replace the flat tire.");
                }
                break;
            case 30:
                if (variableList.get("fault").compareTo("Brakes") == 0) {
                    variableList.replace("solution", "Replace the brake pads / brake fluid.");
                }
                break;
            case 40:
                if (variableList.get("fault").compareTo("Lights") == 0) {
                    variableList.replace("solution", "Replace the headlight bulbs.");
                }
                break;
            case 50:
                if (variableList.get("fault").compareTo("AC") == 0) {
                    variableList.replace("solution", "Replace the compressor.");
                }
                break;
            case 60:
                if (variableList.get("fault").compareTo("Radio") == 0) {
                    variableList.replace("solution", "Replace the radio.");
                }
                break;
            case 70:
                if (variableList.get("fault").compareTo("Shift") == 0) {
                    variableList.replace("solution", "Fix the transmission.");
                }
                break;
            case 80:
                if (variableList.get("fault").compareTo("Noise") == 0) {
                    variableList.replace("solution", "Replace the muffler.");
                }
                break;
            case 90:
                if (variableList.get("fault").compareTo("Unknown") == 0) {
                    variableList.replace("solution", "Unable to identify the fault / Unable to provide solution.");
                }
                break;
        }
    }

    public String[] getList() {
        return clauseVariableList;
    }
    
    public String getGoal(){return goal;}
    
    public String getGoalState(){return variableList.get(getGoal());}
    
    public boolean isVariableSet(String var){        
        return variableList.get(var).compareTo("none") != 0;
    }
}
