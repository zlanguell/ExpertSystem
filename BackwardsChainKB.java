/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystemv2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zachary
 */
public class BackwardsChainKB implements IKnowledgeBase {
    //Number of rules in knowledgebase
    static final int NUM_OF_RULES = 25;
    static final String GOAL_VARIABLE = "fault";

    //Maximum number of variables in a rule
    static final int MAX_VAR_PER_RULE = 2;

    //Conclusion Variable List
    private String[] conclusionVariableList;

    //Variable List
    private final Map<String, String> variableList = new HashMap<>();

    //Clause Variable List
    private String[] clauseVariableList = new String[NUM_OF_RULES * MAX_VAR_PER_RULE];

    //Variable Prompt List
    private final Map<String, String> variablePromptList = new HashMap<>();

    /**
     *
     */
    public BackwardsChainKB() {
        //Fill Variable List
        variableList.put("fault", "none"); //
        variableList.put("prob", "none"); //
        variableList.put("flat", "none"); //
        variableList.put("brakes", "none"); //
        variableList.put("lights", "none"); //
        variableList.put("ac", "none"); //
        variableList.put("radio", "none"); //
        variableList.put("shift", "none"); //
        variableList.put("noise", "none");
        variableList.put("Prob", "none"); //
        variableList.put("Flat", "none"); //
        variableList.put("Brakes", "none"); //
        variableList.put("Lights", "none"); //
        variableList.put("AC", "none"); //
        variableList.put("Radio", "none"); //
        variableList.put("Shift", "none"); //
        variableList.put("Noise", "none");

        //Fill Conclusion Variable List
        conclusionVariableList = new String[NUM_OF_RULES + 1];
        conclusionVariableList[0] = "";
        conclusionVariableList[1] = "Prob";
        conclusionVariableList[2] = "fault";
        conclusionVariableList[3] = "Prob";
        conclusionVariableList[4] = "Flat";
        conclusionVariableList[5] = "fault";
        conclusionVariableList[6] = "Flat";
        conclusionVariableList[7] = "Brakes";
        conclusionVariableList[8] = "fault";
        conclusionVariableList[9] = "Brakes";
        conclusionVariableList[10] = "Lights";
        conclusionVariableList[11] = "fault";
        conclusionVariableList[12] = "Lights";
        conclusionVariableList[13] = "AC";
        conclusionVariableList[14] = "fault";
        conclusionVariableList[15] = "AC";
        conclusionVariableList[16] = "Radio";
        conclusionVariableList[17] = "fault";
        conclusionVariableList[18] = "Radio";
        conclusionVariableList[19] = "Shift";
        conclusionVariableList[20] = "fault";
        conclusionVariableList[21] = "Shift";
        conclusionVariableList[22] = "Noise";
        conclusionVariableList[23] = "fault";
        conclusionVariableList[24] = "Noise";
        conclusionVariableList[25] = "fault";

        //Fill Clause Variable List
        //rule 1
        clauseVariableList[1] = "prob";
        //rule 2
        clauseVariableList[3] = "Prob";
        //rule 3
        clauseVariableList[5] = "prob";
        //rule 4
        clauseVariableList[7] = "Prob";
        clauseVariableList[8] = "flat";
        //rule 5
        clauseVariableList[9] = "Flat";
        //rule 6
        clauseVariableList[11] = "Prob";
        clauseVariableList[12] = "flat";
        //rule 7
        clauseVariableList[13] = "Flat";
        clauseVariableList[14] = "brakes";
        //rule 8
        clauseVariableList[15] = "Brakes";
        //rule 9
        clauseVariableList[17] = "Flat";
        clauseVariableList[18] = "brakes";
        //rule 10
        clauseVariableList[19] = "Brakes";
        clauseVariableList[20] = "lights";
        //rule 11
        clauseVariableList[21] = "Lights";
        //rule 12
        clauseVariableList[23] = "Brakes";
        clauseVariableList[24] = "lights";
        //rule 13
        clauseVariableList[25] = "Lights";
        clauseVariableList[26] = "ac";
        //rule 14
        clauseVariableList[27] = "AC";
        //rule 15
        clauseVariableList[29] = "Lights";
        clauseVariableList[30] = "ac";
        //rule 16
        clauseVariableList[29] = "AC";
        clauseVariableList[30] = "radio";
        //rule 17
        clauseVariableList[31] = "Radio";
        //rule 18
        clauseVariableList[33] = "AC";
        clauseVariableList[34] = "radio";
        //rule 19
        clauseVariableList[35] = "Radio";
        clauseVariableList[36] = "shift";

        //rule 20
        clauseVariableList[37] = "Shift";
        //rule 21
        clauseVariableList[39] = "Radio";
        clauseVariableList[40] = "shift";
        //rule 22
        clauseVariableList[41] = "Shift";
        clauseVariableList[42] = "noise";
        //rule 23
        clauseVariableList[43] = "Noise";
        //rule 24
        clauseVariableList[45] = "Shift";
        clauseVariableList[46] = "noise";
        //rule 25
        clauseVariableList[47] = "Noise";


        //Variable Prompt List
        variablePromptList.put("prob", "Is there a problem with your vehicle?"); //
        variablePromptList.put("flat", "Are all the tires inflated?"); //
        variablePromptList.put("brakes", "Are you able to slow the vehicle?"); //
        variablePromptList.put("lights", "Are the headlights turning on?"); //
        variablePromptList.put("ac", "Is there no Air Conditioning"); //
        variablePromptList.put("radio", "Is radio working?"); //
        variablePromptList.put("shift", "Is the transmission shifting gears?"); //
        variablePromptList.put("noise", "Are there any noises?"); //
    }

    /**
     * @param key
     * @param value
     */
    public void setVariable(String key, String value) {
        variableList.replace(key, value);
    }

    /**
     * @param var
     * @return
     */
    public boolean isVariableSet(String var) {
        return variableList.get(var).compareTo("none") != 0;
    }

    /**
     * @return
     */
    public String[] getConclusionVarList() {
        return conclusionVariableList;
    }

    /**
     * @param ruleNo
     * @return
     */
    public String[] getClauseVariablesList(int ruleNo) {
        String[] temp = new String[MAX_VAR_PER_RULE];
        int counter = 0;
        ruleNo = ruleNo * MAX_VAR_PER_RULE - (MAX_VAR_PER_RULE - 1);
        while (clauseVariableList[ruleNo] != null) {
            temp[counter++] = clauseVariableList[ruleNo++];
        }
        String[] result = new String[counter];
        counter = 0;
        while (temp[counter] != null) {
            result[counter] = temp[counter];
            counter++;
        }
        return result;
    }

    /**
     * @param var
     * @return
     */
    public String getPrompt(String var) {
        return variablePromptList.get(var);
    }

    /**
     * @return
     */
    public String getGoal() {
        return GOAL_VARIABLE;
    }

    /**
     * @return
     */
    public String getGoalState() {
        return variableList.get(getGoal());
    }

    //Rule List

    /**
     * @param ruleNumber
     */
    public void evaluateRule(int ruleNumber) {
        ruleNumber *= 10;
        switch (ruleNumber) {
            case 10:
                if (variableList.get("prob").equals("no")) {
                    variableList.replace("Prob", "no");
                }
                break;
            case 20:
                if (variableList.get("Prob").equals("no")) {
                    variableList.replace("fault", "None");
                }
                break;
            case 30:
                if (variableList.get("prob").equals("yes")) {
                    variableList.replace("Prob", "yes");
                }
                break;
            case 40:
                if (variableList.get("Prob").equals("yes") &&
                        variableList.get("flat").equals("yes")) {
                    variableList.replace("Flat", "yes");
                }
                break;
            case 50:
                if (variableList.get("Flat").equals("yes")) {
                    variableList.replace("fault", "Flat");
                }
                break;
            case 60:
                if (variableList.get("Prob").equals("yes") &&
                        variableList.get("flat").equals("no")) {
                    variableList.replace("Flat", "no");
                }
                break;
            case 70:
                if (variableList.get("Flat").equals("no") &&
                        variableList.get("brakes").equals("yes")) {
                    variableList.replace("Brakes", "yes");
                }
                break;
            case 80:
                if (variableList.get("Brakes").equals("yes")) {
                    variableList.replace("fault", "Brakes");
                }
                break;
            case 90:
                if (variableList.get("Flat").equals("no") &&
                        variableList.get("brakes").equals("no")) {
                    variableList.replace("Brakes", "no");
                }
                break;
            case 100:
                if (variableList.get("Brakes").equals("no") &&
                        variableList.get("lights").equals("yes")) {
                    variableList.replace("Lights", "yes");
                }
                break;
            case 110:
                if (variableList.get("Lights").equals("yes")) {
                    variableList.replace("fault", "Lights");
                }
                break;
            case 120:
                if (variableList.get("Brakes").equals("no") &&
                        variableList.get("lights").equals("no")) {
                    variableList.replace("Lights", "no");
                }
                break;
            case 130:
                if (variableList.get("Lights").equals("no") &&
                        variableList.get("ac").equals("yes")) {
                    variableList.replace("AC", "yes");
                }
                break;
            case 140:
                if (variableList.get("AC").equals("yes")) {
                    variableList.replace("fault", "AC");
                }
                break;
            case 150:
                if (variableList.get("Lights").equals("no") &&
                        variableList.get("ac").equals("no")) {
                    variableList.replace("AC", "no");
                }
                break;
            case 160:
                if (variableList.get("AC").equals("no") &&
                        variableList.get("radio").equals("yes")) {
                    variableList.replace("Radio", "yes");
                }
                break;
            case 170:
                if (variableList.get("Radio").equals("yes")) {
                    variableList.replace("fault", "Radio");
                }
                break;
            case 180:
                if (variableList.get("AC").equals("no") &&
                        variableList.get("radio").equals("no")) {
                    variableList.replace("Radio", "no");
                }
                break;
            case 190:
                if (variableList.get("Radio").equals("no") &&
                        variableList.get("shift").equals("yes")) {
                    variableList.replace("Shift", "yes");
                }
                break;
            case 200:
                if (variableList.get("Shift").equals("yes")) {
                    variableList.replace("fault", "Shift");
                }
                break;
            case 210:
                if (variableList.get("Radio").equals("no") &&
                        variableList.get("shift").equals("no")) {
                    variableList.replace("Shift", "no");
                }
                break;
            case 220:
                if (variableList.get("Shift").equals("no") &&
                        variableList.get("noise").equals("yes")) {
                    variableList.replace("Noise", "yes");
                }
                break;
            case 230:
                if (variableList.get("Noise").equals("yes")) {
                    variableList.replace("fault", "Noise");
                }
                break;
            case 240:
                if (variableList.get("Shift").equals("no") &&
                        variableList.get("noise").equals("no")) {
                    variableList.replace("Noise", "no");
                }
                break;
            case 250:
                if (variableList.get("Noise").equals("no")) {
                    variableList.replace("fault", "Unknown");
                }
                break;
        }
    }

}
