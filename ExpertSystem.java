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
public class ExpertSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        String problem;
        InferenceMachine im = new InferenceMachine();
        KnowledgeBase kb = new KnowledgeBase();
        problem = im.diagnosis(kb);
        System.out.print(problem);
    }
    
}
