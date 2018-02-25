package expertsystemv2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Zachary
 */
public class BackwardsChainKB  {
    //Number of rules in knowledgebase
    static final int NUM_OF_RULES = 25;
    static final String GOAL_VARIABLE = "fault";

    //Maximum number of variables in a rule
    static final int MAX_VAR_PER_RULE = 3;

    //Conclusion Variable List
    private String[] conclusionVariableList;

    //Variable List
    private final Map<String, String> variableList = new HashMap<>();
    
    //Clause Variable List size is set considering max number of variables per rule
    private String[] clauseVariableList = new String[NUM_OF_RULES * MAX_VAR_PER_RULE];

    //Variable Prompt List
    private final Map<String, String> variablePromptList = new HashMap<>();

   /**
     * Initializes variable list, conclusion variable list and clause variable list and prompt list to defaults.
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
        clauseVariableList[4] = "Prob";
        //rule 3
        clauseVariableList[7] = "prob";
        //rule 4
        clauseVariableList[10] = "Prob";
        clauseVariableList[11] = "flat";
        //rule 5
        clauseVariableList[13] = "Flat";
        //rule 6
        clauseVariableList[16] = "Prob";
        clauseVariableList[17] = "flat";
        //rule 7
        clauseVariableList[19] = "Flat";
        clauseVariableList[20] = "brakes";
        //rule 8
        clauseVariableList[22] = "Brakes";
        //rule 9
        clauseVariableList[25] = "Flat";
        clauseVariableList[26] = "brakes";
        //rule 10
        clauseVariableList[28] = "Brakes";
        clauseVariableList[29] = "lights";
        //rule 11
        clauseVariableList[31] = "Lights";
        //rule 12
        clauseVariableList[34] = "Brakes";
        clauseVariableList[35] = "lights";
        //rule 13
        clauseVariableList[37] = "Lights";
        clauseVariableList[38] = "ac";
        //rule 14
        clauseVariableList[40] = "AC";
        //rule 15
        clauseVariableList[43] = "Lights";
        clauseVariableList[44] = "ac";
        //rule 16
        clauseVariableList[46] = "AC";
        clauseVariableList[47] = "radio";
        //rule 17
        clauseVariableList[49] = "Radio";
        //rule 18
        clauseVariableList[52] = "AC";
        clauseVariableList[53] = "radio";
        //rule 19
        clauseVariableList[55] = "Radio";
        clauseVariableList[56] = "shift";
        //rule 20
        clauseVariableList[58] = "Shift";
        //rule 21
        clauseVariableList[61] = "Radio";
        clauseVariableList[62] = "shift";
        //rule 22
        clauseVariableList[64] = "Shift";
        clauseVariableList[65] = "noise";
        //rule 23
        clauseVariableList[67] = "Noise";
        //rule 24
        clauseVariableList[70] = "Shift";
        clauseVariableList[71] = "noise";
        //rule 25
        clauseVariableList[73] = "Noise";


        //Variable Prompt List
        variablePromptList.put("prob", "Is there a problem with your vehicle?"); //
        variablePromptList.put("flat", "Are the tires flat or deflated?"); //
        variablePromptList.put("brakes", "Are your brakes squeaking?"); //
        variablePromptList.put("lights", "Are the headlights broken?"); //
        variablePromptList.put("ac", "Is there a problem with the air conditioning?"); //
        variablePromptList.put("radio", "Is there a problem with the radio?"); //
        variablePromptList.put("shift", "Is there a problem with shifting gears?"); //
        variablePromptList.put("noise", "Are there any noises?"); //
    }

    /**
     * Sets an existing variable in variable list to a new value.
     *
     * @param key   String: Key in the map whose value is to be changed
     * @param value String: New value to be replaced for the corresponding key supplied
     */
    public void setVariable(String key, String value) {
        variableList.replace(key, value);
    }
    /**
     * Checks if a variable is not set to "none" in variable list
     *
     * @param var String - variable to be checked
     * @return Boolean if variable is set to "none"
     */
    public boolean isVariableSet(String var) {
        return variableList.get(var).compareTo("none") != 0;
    }

     /** Returns an array initialized conclusion variables
     * @return String Array of Conclusion variables
     */
    public String[] getConclusionVarList() {
        return conclusionVariableList;
    }
    
   /**
     * Returns an array of clause variable list corresponding to a particular rule number
     *
     * @param ruleNo int - Rule whose clause variable list is required
     * @return String Array - An array of clause variables.
     */
    public String[] getClauseVariablesList(int ruleNo) {
        String[] temp = new String[MAX_VAR_PER_RULE]; //initialze temp array to max number of rules
        int counter = 0;
        ruleNo = ruleNo * MAX_VAR_PER_RULE - (MAX_VAR_PER_RULE - 1); // get the beginning of array for correspoding rule
        while (clauseVariableList[ruleNo] != null) { //copy the array to temp
            temp[counter++] = clauseVariableList[ruleNo++];
        }
        String[] result = new String[counter];
        counter = 0;
        while (temp[counter] != null) { //trim the array of nulls
            result[counter] = temp[counter];
            counter++;
        }
        return result;
    }

    /**
     * Returns a prompt string to corresponding variable.
     *
     * @param var String: Variable whose prompt has to be returned.
     * @return String a prompt which can be answered in yes/no format.
     */
    public String getPrompt(String var) {
        return variablePromptList.get(var);
    }

    /**
     * Returns goal variable. Default="fault".
     *
     * @return String "fault"
     */
    public String getGoal() {
        return GOAL_VARIABLE;
    }

    /**
     * Returns current state of goal variable.
     *
     * @return String "none" if goal variable is not set.
     */
    public String getGoalState() {
        return variableList.get(getGoal());
    }

    //Rule List

    /**
     * Mapped as per the decision tree of the: evaluates a rule and checks if corresponding variables are set to yes/no. And sets
     * new variables if the conditions are satisfied.
     *
     * @param ruleNumber int Rule number.
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
