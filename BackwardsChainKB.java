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
public class BackwardsChainKB implements IKnowledgeBase{
    //Number of rules in knowledgebase
    static final int NUM_OF_RULES = 26;
    static final String GOAL_VARIABLE = "fault";
    
    //Maximum number of variables in a rule
    static final int MAX_VAR_PER_RULE = 8;
    
    //Conclusion Variable List
    private String[] conclusionVariableList;
    
    //Variable List
    private final Map<String, String> variableList = new HashMap<>();

    //Clause Variable List
    private String[] clauseVariableList = new String[NUM_OF_RULES *MAX_VAR_PER_RULE];
    
    //Variable Prompt List
    private final Map<String, String> variablePromptList = new HashMap<>();
    
    /**
     *
     */
    public BackwardsChainKB(){
        //Fill Variable List
        variableList.put("fault", "none");        
        variableList.put("problem", "none");
        variableList.put("gas", "none");
        variableList.put("prep", "none");
        variableList.put("crank", "none");
        variableList.put("lights", "none");
        variableList.put("electronics", "none");
        variableList.put("runs", "none");
        variableList.put("fuse", "none");
        variableList.put("start", "none");
        variableList.put("slow", "none");
        variableList.put("braking", "none");
        variableList.put("shift", "none");
        variableList.put("steering", "none");
        variableList.put("noise", "none");
        variableList.put("overheat", "none");
        variableList.put("ac", "none");
        variableList.put("smoke", "none");
        variableList.put("black", "none");
        variableList.put("leak", "none");
        variableList.put("tire", "none");
        variableList.put("control", "none");
        variableList.put("hood", "none");
        
        //Fill Conclusion Variable List
        conclusionVariableList =  new String[NUM_OF_RULES+1];
        conclusionVariableList[0] = "";
        conclusionVariableList[1] = "fault";
        conclusionVariableList[2] = "fault";
        conclusionVariableList[3] = "prep";
        conclusionVariableList[4] = "fault";
        conclusionVariableList[5] = "electronics";
        conclusionVariableList[6] = "fault";
        conclusionVariableList[7] = "fault";
        conclusionVariableList[8] = "fault"; 
        conclusionVariableList[9] = "fault"; 
        conclusionVariableList[10] = "runs"; 
        conclusionVariableList[11] = "fault";
        conclusionVariableList[12] = "braking";
        conclusionVariableList[13] = "fault";
        conclusionVariableList[14] = "fault";
        conclusionVariableList[15] = "fault";
        conclusionVariableList[16] = "control";
        conclusionVariableList[17] = "fault";
        conclusionVariableList[18] = "fault";
        conclusionVariableList[19] = "fault";
        conclusionVariableList[20] = "leak";
        conclusionVariableList[21] = "fault";
        conclusionVariableList[22] = "fault";
        conclusionVariableList[23] = "fault";
        conclusionVariableList[24] = "fault";
        conclusionVariableList[25] = "fault";
        conclusionVariableList[26] = "electronics";
        
        //Fill Clause Variable List
        //rule 1
        clauseVariableList[1] = "problem";
        //rule 2
        clauseVariableList[9] = "problem";
        clauseVariableList[10] = "gas";
        //rule 3
        clauseVariableList[17] = "problem";
        clauseVariableList[18] = "gas";
        //rule 4
        clauseVariableList[25] = "prep";
        clauseVariableList[26] = "lights";
        clauseVariableList[27] = "crank";
        //rule 5
        clauseVariableList[33] = "prep";
        clauseVariableList[34] = "lights";
        clauseVariableList[35] = "crank";
        //rule 6
        clauseVariableList[41] = "electronics";
        clauseVariableList[42] = "fuse";
        //rule 7
        clauseVariableList[49] = "electronics";
        clauseVariableList[50] = "fuse";
        //rule 8
        clauseVariableList[57] = "prep";
        clauseVariableList[58] = "lights";
        clauseVariableList[59] = "crank";
        //rule 9
        clauseVariableList[65] = "prep";
        clauseVariableList[66] = "lights";
        clauseVariableList[67] = "crank";
        clauseVariableList[68] = "start";
        //rule 10
        clauseVariableList[73] = "prep";
        clauseVariableList[74] = "lights";
        clauseVariableList[75] = "crank";
        clauseVariableList[76] = "start";
        //rule 11
        clauseVariableList[81] = "runs";
        clauseVariableList[82] = "shift";
        //rule 12
        clauseVariableList[89] = "runs";
        clauseVariableList[90] = "slow";
        //rule 13
        clauseVariableList[97] = "runs";
        clauseVariableList[98] = "slow";
        clauseVariableList[99] = "noise";
        //rule 14
        clauseVariableList[105] = "braking";
        clauseVariableList[106] = "noise";
        //rule 15
        clauseVariableList[113] = "braking";
        clauseVariableList[114] = "noise";
        //rule 16
        clauseVariableList[121] = "runs";
        clauseVariableList[122] = "steering";
        //rule 17
        clauseVariableList[129] = "control";
        clauseVariableList[130] = "tire";
        //rule 18
        clauseVariableList[137] = "control";
        clauseVariableList[138] = "tire";
        //rule 19
        clauseVariableList[145] = "runs";
        clauseVariableList[146] = "smoke";
        clauseVariableList[147] = "hood";
        //rule 20
        clauseVariableList[153] = "runs";
        clauseVariableList[154] = "smoke";
        clauseVariableList[155] = "hood";
        //rule 21
        clauseVariableList[161] = "leak";
        clauseVariableList[162] = "black";
        //rule 22
        clauseVariableList[169] = "leak";
        clauseVariableList[170] = "black";
        //rule 23
        clauseVariableList[177] = "runs";
        clauseVariableList[178] = "ac";
        //rule 24
        clauseVariableList[185] = "runs";
        clauseVariableList[186] = "overheat";
        //rule 25
        clauseVariableList[193] = "runs";
        clauseVariableList[194] = "slow";
        clauseVariableList[195] = "noise";
        clauseVariableList[196] = "steering";
        clauseVariableList[197] = "smoke";
        clauseVariableList[198] = "ac";
        clauseVariableList[199] = "overheat";
        //rule 26
        clauseVariableList[201] = "prep";
        clauseVariableList[202] = "lights";
        clauseVariableList[203] = "crank";
        
        //Variable Prompt List
        variablePromptList.put("problem", "Is there a problem with your vehicle?");
        variablePromptList.put("gas", "Is there gas in your vehicle?");
        variablePromptList.put("crank", "Does your engine crank?");
        variablePromptList.put("lights", "Are the headlights turning on?");
        variablePromptList.put("fuse", "Are any fuses blown?");
        variablePromptList.put("start", "Does your engine start?");
        variablePromptList.put("slow", "Are you able to slow the vehicle?");
        variablePromptList.put("shift", "Is the transmission shifting gears?");
        variablePromptList.put("steering", "Are you having difficulty steering the vehicle?");
        variablePromptList.put("noise", "Are there any noises?");
        variablePromptList.put("overheat", "Is the engine overheating");
        variablePromptList.put("ac", "Is there no Air Conditioning");
        variablePromptList.put("smoke", "Is there smoke coming from the vehicle?");
        variablePromptList.put("black", "Is the smoke black?");
        variablePromptList.put("tire", "Are all the tires inflated?");
        variablePromptList.put("hood", "Is the smoke coming from the hood?");

    }
    
    /**
     *
     * @param key
     * @param value
     */
    public void setVariable(String key, String value){
      variableList.replace(key, value);
    }
    
    /**
     *
     * @param var
     * @return
     */
    public boolean isVariableSet(String var){        
        return variableList.get(var).compareTo("none") != 0;
    }
    
    /**
     *
     * @return
     */
    public String[] getConclusionVarList(){
        return conclusionVariableList;
    }
    
    /**
     *
     * @param ruleNo
     * @return
     */
    public String[] getClauseVariablesList(int ruleNo){
        String[] temp = new String[MAX_VAR_PER_RULE];
        int counter = 0;
        ruleNo = ruleNo * MAX_VAR_PER_RULE - (MAX_VAR_PER_RULE-1);
        while(clauseVariableList[ruleNo]!=null){
            temp[counter++] = clauseVariableList[ruleNo++];    
        }
        String[] result = new String[counter];
        counter = 0;
        while (temp[counter]!=null){
            result[counter] = temp[counter];
            counter++;
        }
        return result;
    }

    /**
     *
     * @param var
     * @return
     */
    public String getPrompt(String var){
        return variablePromptList.get(var);
    }

    /**
     *
     * @return
     */
    public String getGoal() {
        return GOAL_VARIABLE;
    }
    
    /**
     *
     * @return
     */
    public String getGoalState(){
        return variableList.get("fault");
    }
    
    //Rule List

    /**
     *
     * @param ruleNumber
     */
    public void evaluateRule(int ruleNumber) {
        ruleNumber *=10;
        switch (ruleNumber) {
            case 10:
                if (variableList.get("problem").compareTo("no")==0) {
                    variableList.replace("fault", "None");
                }
                break;
            case 20:
                if (variableList.get("problem").compareTo("yes") == 0 && 
                        variableList.get("gas").compareTo("no") == 0) {
                    variableList.replace("fault", "Gas");
                }
                break;
            case 30:
                if (variableList.get("problem").compareTo("yes") == 0 &&
                        variableList.get("gas").compareTo("yes") == 0) {
                    variableList.replace("prep", "yes");
                }
                break;
            case 40:
                if (variableList.get("prep").compareTo("yes") == 0 && 
                        variableList.get("lights").compareTo("no") == 0 && 
                                variableList.get("crank").compareTo("no") == 0) {
                    variableList.replace("fault", "Battery");
                }
                break;
            case 50:
                if (variableList.get("prep").compareTo("yes") == 0 && 
                        variableList.get("lights").compareTo("no") == 0 && 
                                variableList.get("crank").compareTo("yes") == 0) {
                    variableList.replace("electronics", "yes");
                }
                break;
            case 60:
                if (variableList.get("electronics").compareTo("no")==0&& 
                        variableList.get("fuse").compareTo("yes")==0) {
                     variableList.replace("fault", "Fuse");
                }
                break;
            case 70:
                if (variableList.get("electronics").compareTo("yes")==0&& 
                        variableList.get("fuse").compareTo("no")==0) {
                     variableList.replace("fault", "Bulb");
                }
                break;
            case 80:
                if (variableList.get("prep").compareTo("yes") == 0 && 
                        variableList.get("lights").compareTo("yes") == 0 && 
                                variableList.get("crank").compareTo("yes") == 0) {
                    variableList.replace("fault", "Starter");
                }
                break;
            case 90:
                if (variableList.get("prep").compareTo("yes") == 0 && 
                        variableList.get("lights").compareTo("yes") == 0 && 
                                variableList.get("crank").compareTo("yes") == 0 &&
                        variableList.get("start").compareTo("no") == 0) {
                    variableList.replace("fault", "FuelPump");
                }
                break;
            case 100:
                if (variableList.get("prep").compareTo("yes") == 0 && 
                        variableList.get("lights").compareTo("yes") == 0 && 
                                variableList.get("crank").compareTo("yes") == 0 &&
                        variableList.get("start").compareTo("yes") == 0) {
                    variableList.replace("runs", "yes");
                }
                break;
            case 110:
                if (variableList.get("runs").compareTo("yes") == 0 &&
                        variableList.get("shift").compareTo("no") == 0) {
                    variableList.replace("fault", "Transmission");
                }
                break;
            case 120:
                if (variableList.get("runs").compareTo("yes") == 0 &&
                        variableList.get("slow").compareTo("yes") == 0) {
                    variableList.replace("braking", "yes");
                }
                break;
            case 130:
                if (variableList.get("runs").compareTo("yes") == 0 &&
                        variableList.get("slow").compareTo("no") == 0 &&
                        variableList.get("noise").compareTo("yes") == 0) {
                     variableList.replace("fault", "Muffler");
                }
                break;
            case 140:
                if (variableList.get("braking").compareTo("yes") == 0 &&
                        variableList.get("noise").compareTo("yes") == 0) {
                     variableList.replace("fault", "BrakePad");
                }
                break;
            case 150:
                if (variableList.get("braking").compareTo("yes") == 0 &&
                        variableList.get("noise").compareTo("no") == 0) {
                     variableList.replace("fault", "BrakeFluid");
                }
                break;
            case 160:
                if (variableList.get("braking").compareTo("yes") == 0 &&
                        variableList.get("steering").compareTo("yes") == 0) {
                variableList.replace("control", "yes");
                }
                break;
            case 170:
                if (variableList.get("control").compareTo("yes") == 0 &&
                        variableList.get("tire").compareTo("no") == 0) {
                     variableList.replace("fault", "Flat");
                }
                break;
            case 180:
                if (variableList.get("control").compareTo("yes") == 0 &&
                        variableList.get("tire").compareTo("yes") == 0) {
                      variableList.replace("fault", "Alignment");
                }
                break;
            case 190:
                if (variableList.get("runs").compareTo("yes") == 0 &&
                        variableList.get("smoke").compareTo("yes") == 0 &&
                        variableList.get("hood").compareTo("no") == 0) {
                    variableList.replace("fault", "CatConv");
                }
                break;
            case 200:
                if (variableList.get("runs").compareTo("yes") == 0 &&
                        variableList.get("smoke").compareTo("yes") == 0 &&
                        variableList.get("hood").compareTo("yes") == 0) {
                    variableList.replace("leak", "yes");
                }
                break;
            case 210:
                if (variableList.get("leak").compareTo("yes") == 0 &&
                        variableList.get("black").compareTo("yes") == 0) {
                    variableList.replace("fault", "OilLeak");
                }
                break;
            case 220:
                if (variableList.get("leak").compareTo("yes") == 0 &&
                        variableList.get("black").compareTo("no") == 0) {
                    variableList.replace("fault", "Radiator");
                }
                break;
            case 230:
                if (variableList.get("runs").compareTo("yes") == 0 &&
                        variableList.get("ac").compareTo("no") == 0) {
                    variableList.replace("fault", "Freon");
                }
                break;
            case 240:
                if (variableList.get("runs").compareTo("yes") == 0 &&
                        variableList.get("overheat").compareTo("yes") == 0) {
                    variableList.replace("fault", "Coolant");
                }
                break;
            case 250:
                if (variableList.get("runs").compareTo("no") == 0 &&
                        variableList.get("slow").compareTo("no") == 0&&
                        variableList.get("noise").compareTo("no") == 0&&
                        variableList.get("steering").compareTo("no") == 0&&
                        variableList.get("smoke").compareTo("no") == 0&&
                        variableList.get("ac").compareTo("no") == 0&&
                        variableList.get("overheat").compareTo("no") == 0) {
                    variableList.replace("fault", "Unknown");
                }
                break;
            case 260:
                if (variableList.get("prep").compareTo("yes") == 0 && 
                        variableList.get("lights").compareTo("yes") == 0 && 
                                variableList.get("crank").compareTo("yes") == 0) {
                    variableList.replace("electronics", "no");
                }
                break;
        }
    }

}
