/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
     *
     * @param bKB
     * @param fKB
     */
    public InferenceMachine(BackwardsChainKB bKB, ForwardChainKB fKB) {
        this.bKB = bKB;
        this.fKB = fKB;
    }

    /**
     *
     */
    public void start() {
        backwardChain(bKB.getGoal());
        System.out.print("The problem is: " + bKB.getGoalState() + ". \n");
        forwardChain(bKB.getGoalState());
    }

    /**
     *
     * @param goal
     */
    public void backwardChain(String goal) {
        String[] conclusionVar = bKB.getConclusionVarList();
        int ruleNumber = -1;
        for (String s : conclusionVar) {
            ruleNumber++;
            if (!bKB.isVariableSet(goal)) {
                if (goal.compareTo(s) == 0) {
                    String[] clauseVariables = bKB.getClauseVariablesList(ruleNumber);
                    for (String cv : clauseVariables) {
                        if (goal.compareTo(cv) != 0) {
                            backwardChain(cv);
                        }
                    }
                    bKB.evaluateRule(ruleNumber);
                }
            } else {
                return;
            }
        }

        if (!bKB.isVariableSet(goal)) {
            bKB.setVariable(goal, getUserInput(bKB.getPrompt(goal)));
        }
    }
    
    /**
     *
     * @param start
     */
    public void forwardChain(String start){
        
    }

    /**
     *
     * @param prompt
     * @return
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
