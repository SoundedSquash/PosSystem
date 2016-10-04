/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy;

/**
 *
 * @author wboyer
 */
public class Startup {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Register register = new Register();
        
        //Customer #C100
        register.startNewSale("C100");
        register.addProduct("A100",2);
        register.addProduct("B101",1);
        register.addProduct("C103",3);
        register.endSale();
    }
    
}
