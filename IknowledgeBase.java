/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystem;

/**
 *
 * 
 */
public interface IknowledgeBase {
    public String getGoal();
    public boolean goalFound();
    public int getRuleCount();
    public void rules(int ruleNumber);
    public void setVariable (String varName, boolean value)throws Exception;
    public boolean isVariableSet(String varName);
    public boolean checkConclusionList(String consequence, int ruleNumber);
    public String[] checkClauseVariableList(int ruleNumber);
    public String getPromptString(String keyName) throws Exception;
}
