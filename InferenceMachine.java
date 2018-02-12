/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystem;

/**
 *
 * @author Zachary
 */
public class InferenceMachine {

    private IknowledgeBase kB;
    private String goal;

    public String diagnosis(IknowledgeBase knowledgeBase) throws Exception{
        kB = knowledgeBase;
        String goalVariable = kB.getGoal();      
        while (!kB.goalFound()) {
            try{
            checkConclusion(goalVariable);
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return goal;
    }

    private void checkConclusion(String conclusionVar) throws Exception{
        int counter = 1;
        String[] variables;
        while (!kB.isVariableSet(conclusionVar)) {
            if (counter <= kB.getRuleCount()) {
                if (kB.checkConclusionList(conclusionVar, counter)) {
                    //Check Variable Lists
                    variables = kB.checkClauseVariableList(counter);
                    for (String s : variables) {
                        if (s!=null&&!kB.isVariableSet(s)) {
                            checkConclusion(s);
                        }
                    }                    
                } 
                counter++;                
            }
            else{
                kB.setVariable(conclusionVar, getUserInput(kB.getPromptString(conclusionVar)));                
            }
        }
    }
    private boolean getUserInput(String prompt){
        boolean answer=true;
        System.out.println(prompt+"[y/n]: ");
        return answer;
    }
    public String solution(IknowledgeBase knowledgeBase, String goalString) {
        kB = knowledgeBase;

        return goal;
    }
}
