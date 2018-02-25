package expertsystemv2;

import java.util.Scanner;

/**
 *
 * @author Zachary
 */
public class InferenceMachine {

    private BackwardsChainKB bKB;
    private ForwardChainKB fKB;

    /**
     * Initializes local backwards and forward chain variables and Inference machine.
     *
     * @param bKB BackwardsChainKB - Object of BackwardsChain knowledge base to be processed.
     * @param fKB ForwardChainKB - Object of BackwardsChain knowledge base to be processed.
     */
    public InferenceMachine(BackwardsChainKB bKB, ForwardChainKB fKB) {
        this.bKB = bKB;
        this.fKB = fKB;
    }

     /**Begins process of finding the problem using backwards chain and a solution to that problem
     * using forward chaining.
     */
    public void start() {
        backwardChain(bKB.getGoal()); //gets goal variable from knowledge base and begins backward chaining on it.
        System.out.print("The problem is: " + bKB.getGoalState() + ". \n");
        fKB.setVariable(bKB.getGoal(), bKB.getGoalState()); //sets backward chain knowledge base's goal and goal state as a variable in
                                                            //forward chain kb
       
        forwardChain(bKB.getGoal()); //sends found goal to forward chaining.
        System.out.print("The "+fKB.getGoal()+" is: " + fKB.getGoalState() + "\n");
    }

     /**
     * Tries to find the problem by evaluating series of conclusion variables/user input.
     * 1) The function gets a conclusion variable array list analyze
     * 2) for every conclusion variable
     *  a) If the goal is not set:
     *      - check if the goal is same as current conclusion variable.
     *      - get the clause variable array for its corresponding rule.
     *        - iterate over the clause variable list recursively if its not the goal, repeat above process for it.
     *      - evaluate the rule for specified rule number
     *   else return
     *   Prompt user to define a variable if none is available.
     * @param goal String - Goal variable whose value has to be found. Goal variable denotes the fault/issue that needs
     *             to be diagnosed using backwards chaining.
     */
    public void backwardChain(String goal) {
        String[] conclusionVar = bKB.getConclusionVarList();//gets string array of conclusion variables to assess.
        int ruleNumber = -1; //initialized to -1 as it is later incremented to 0.
        for (String s : conclusionVar) {//for every variable in conclusion array..
            ruleNumber++;
            if (!bKB.isVariableSet(goal)) {// check if the goal has not been set else return
                if (goal.compareTo(s) == 0) {//if goal is not the variable continue
                    String[] clauseVariables = bKB.getClauseVariablesList(ruleNumber);
                    for (String cv : clauseVariables) { // for each clause variable check if its a goal or find its
                        if (goal.compareTo(cv) != 0) {
                            backwardChain(cv);
                        }
                    }
                    bKB.evaluateRule(ruleNumber);//Defines a variable in variableList by evaluating specified rule.
                }
            } else {
                return;
            }
        }
        //get conclusion variable defined by the user
        if (!bKB.isVariableSet(goal)) {
            bKB.setVariable(goal, getUserInput(bKB.getPrompt(goal)));
        }
    }

     /** For every variable in clause variable list,
     *  - if goal is set, break
     *  - if "start" variable is same as the clause variable evaluate rule
     *  - else try next rule
     *
     * @param start String: Start variable is the problem whose solution is to be found using Forward Chaining.
     */
    public void forwardChain(String var) {
        String[] clauseVariableList = fKB.getList();        
        int index = 0;        
        for (String s: clauseVariableList) {
            if(fKB.isVariableSet(fKB.getGoal())){
                break;
            }
            if (s != null && s.compareTo(var)==0){
                fKB.evaluateRule(index++);
            }else
            {
                index++;
            }
        }
        
    }

    /** Displays a prompt and get user input in a yes/no format
     * @param prompt String - Display a prompt which can be answered in yes/no form.
     * @return String "yes" if user inputs "y" or "no" otherwise.
     */
    public String getUserInput(String prompt) {
        System.out.println(prompt + " [y/n]: ");
        Scanner reader = new Scanner(System.in);
        String answer = "";
        while (answer.compareTo("y") != 0 && answer.compareTo("n") != 0) {
            answer = reader.nextLine();
        }
        if (answer.compareTo("y") == 0) {
            return "yes";
        } else {
            return "no";
        }
    }

}
