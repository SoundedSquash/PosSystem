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
        Storage storage = new InternalDatabase();
        
        //Customer #C100
        register.startNewSale("C100", storage);
        register.addProduct("A100",2, storage);
        register.addProduct("B101",1, storage);
        register.addProduct("C103",3, storage);
        register.endSale();
    }
    
}
