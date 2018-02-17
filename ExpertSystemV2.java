/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expertsystemv2;

/**
 *
 * @author Zachary
 */
public class ExpertSystemV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BackwardsChainKB kb = new BackwardsChainKB();
        ForwardChainKB fkb = new ForwardChainKB();
        InferenceMachine IM = new InferenceMachine(kb, fkb);
        IM.start();
    }
    
}
