/**
 *
 *
 *
 */
package expertsystem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * @author Zachary
 */
public class KnowledgeBase implements IknowledgeBase {

    static final int NUMBER_OF_RULES = 25;
    private String[] conclusionList;
    private final String[] clauseVariableList;
    private final String goal = "fault";
    private String fault;
    private boolean faultFound;
    private Boolean problem, gas, prep, crank, lights, electronics, runs, fuse, start,
            slow, braking, shift, steering, noise, overheat, ac, smoke, black,
            leak, tire, control, hood;
    private final Map<String, Object> variableList = new HashMap<>();
    private final Map<String, String> promptList = new HashMap<>();

    /**
     *
     */
    public KnowledgeBase() {
        clauseVariableList = new String[(NUMBER_OF_RULES * 8) + 1];
        faultFound = false;
        conclusionList = new String[NUMBER_OF_RULES];
        //INITIALIZE CONCLUSION LIST
        conclusionList = new String[]{"", "fault", "fault", "prep", "fault", "electronics", "fault",
            "fault", "fault", "fault", "runs", "fault", "braking", "fault", "fault", "fault", "control", "fault", "fault",
            "fault", "leak", "fault", "fault", "fault", "fault", "fault"};

        //INITIALIZE THE VARIABLE LIST
        
        variableList.put("fault", fault);        
        variableList.put("problem", problem);
        variableList.put("gas", gas);
        variableList.put("prep", prep);
        variableList.put("crank", crank);
        variableList.put("lights", lights);
        variableList.put("electronics", electronics);
        variableList.put("runs", runs);
        variableList.put("fuse", fuse);
        variableList.put("start", start);
        variableList.put("slow", slow);
        variableList.put("braking", braking);
        variableList.put("shift", shift);
        variableList.put("steering", steering);
        variableList.put("noise", noise);
        variableList.put("overheat", overheat);
        variableList.put("ac", ac);
        variableList.put("fault", smoke);
        variableList.put("black", black);
        variableList.put("leak", leak);
        variableList.put("tire", tire);
        variableList.put("control", control);
        variableList.put("hood", hood);

        //INITIALIZE CLAUSE VARIABLE LIST
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
        clauseVariableList[130] = "tyres";
        //rule 18
        clauseVariableList[137] = "control";
        clauseVariableList[138] = "tyres";
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

        //INITIALIZE PROMPTLIST MAP
        promptList.put("problem", "Is there a problem with your vehicle?");
        promptList.put("gas", "Is there gas in your vehicle?");
        promptList.put("crank", "Does your engine crank?");
        promptList.put("lights", "Are the headlights turning on?");
        promptList.put("fuse", "Are any fuses blown?");
        promptList.put("start", "Does your engine start?");
        promptList.put("slow", "Are you able to slow the vehicle?");
        promptList.put("shift", "Is the transmission shifting gears?");
        promptList.put("steering", "Are you having difficulty steering the vehicle?");
        promptList.put("noise", "Are there any noises?");
        promptList.put("overheat", "Is the engine overheating");
        promptList.put("ac", "Is there no Air Conditioning");
        promptList.put("smoke", "Is there smoke coming from the vehicle?");
        promptList.put("black", "Is the smoke black?");
        promptList.put("tire", "Are all the tires inflated?");
        promptList.put("hood", "Is the smoke coming from the hood?");
    }

    private void setGoal(String faultType) {
        faultFound = true;
        fault = faultType;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean goalFound() {
        return faultFound;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String getGoal() {
        return goal;        //RETURN GOAL VARIABLE TO INFERENCE MACHINE
    }
    
    @Override
    public int getRuleCount(){
        return NUMBER_OF_RULES;
    }
    /**
     *
     * @param consequence
     * @param ruleNumber
     * @return
     */
    @Override
    public boolean checkConclusionList(String consequence, int ruleNumber) {
        //RETURNS MATCH FOR CONSEQUENCE ON CONCLUSION LIST
        return (consequence.compareTo(conclusionList[ruleNumber]) == 0);
    }

    /**
     *
     * @param ruleNumber
     * @return
     */
    @Override
    public String[] checkClauseVariableList(int ruleNumber) {
        //CONVERT RULE NUMBER AND RETURN CLAUSE VARIABLES ASSOCIATED WITH RULE
        ruleNumber = ruleNumber * 8 - 7;
        String s = clauseVariableList[ruleNumber];
        String[] results = new String[9];
        int counter = 1;
        while (s!=null) {
            results[counter++] = s;
            s=clauseVariableList[++ruleNumber];
        }
        return results;
    }

    /**
     *
     * @param varName
     * @return
     */
    @Override
    public boolean isVariableSet(String varName) {
        return variableList.get(varName) != null;
    }

    /**
     *
     * @param varName
     * @param value
     * @throws Exception
     */
    @Override
    public void setVariable(String varName, boolean value) throws Exception {
        try {
            variableList.replace(varName, value);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     *
     * @param keyName
     * @return
     * @throws Exception
     */
    @Override
    public String getPromptString(String keyName) throws Exception {
        try {
            return promptList.get(keyName);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    /**
     *
     * @param ruleNumber
     */
    @Override
    public void rules(int ruleNumber) {
        switch (ruleNumber) {
            case 10:
                if (problem == false) {
                    setGoal("None");
                }
            case 20:
                if (problem == true && gas == false) {
                    setGoal("Gas");
                }
            case 30:
                if (problem == false && gas == true) {
                    prep = true;
                }
            case 40:
                if (prep == true && lights == false && crank == false) {
                    setGoal("Battery");
                }
            case 50:
                if (prep == true && lights == false && crank == true) {
                    electronics = true;
                }
            case 60:
                if (electronics == true && fuse == true) {
                    setGoal("Fuse");
                }
            case 70:
                if (electronics == true && fuse == false) {
                    setGoal("Bulb");
                }
            case 80:
                if (prep == true && lights == true && crank == true) {
                    setGoal("Starter");
                }
            case 90:
                if (prep == true && lights == false && crank == true && start == false) {
                    setGoal("FuelPump");
                }
            case 100:
                if (prep == true && lights == true && crank == true && start == true) {
                    runs = true;
                }
            case 110:
                if (runs == true && shift == false) {
                    setGoal("Transmission");
                }
            case 120:
                if (runs == true && slow == true) {
                    braking = true;
                }
            case 130:
                if (runs == true && slow == false && noise == true) {
                    setGoal("Muffler");
                }
            case 140:
                if (braking == true && noise == true) {
                    setGoal("BrakePad");
                }
            case 150:
                if (braking == true && noise == false) {
                    setGoal("BrakeFluid");
                }
            case 160:
                if (runs == true && steering == true) {
                    control = true;
                }
            case 170:
                if (control == true && tire == false) {
                    setGoal("Flat");
                }
            case 180:
                if (control == true && tire == true) {
                    setGoal("Alignment");
                }
            case 190:
                if (runs == true && smoke == true && hood == false) {
                    setGoal("CatConv");
                }
            case 200:
                if (runs == true && smoke == true && hood == true) {
                    leak = true;
                }
            case 210:
                if (leak == true && black == true) {
                    setGoal("OilLeak");
                }
            case 220:
                if (leak == true && black == false) {
                    setGoal("Radiator");
                }
            case 230:
                if (runs == true && ac == false) {
                    setGoal("Freon");
                }
            case 240:
                if (runs == true && overheat == true) {
                    setGoal("Coolant");
                }
            case 250:
                if (runs == true && slow == false && noise == false
                        && steering == false && smoke == false && ac == false && overheat == false) {
                    setGoal("Unknown");
                }
        }
    }

}
