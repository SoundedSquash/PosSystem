/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy;

import wtb_discountstrategy.Input.*;
import wtb_discountstrategy.Output.*;
import wtb_discountstrategy.Storage.*;

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
        Reader reader = new NoReader();
        Writer writer = new ConsoleWriter();
        
        //Customer #C100
        register.startNewSale("C100", storage);
        register.addProduct("P100",2, storage);
        register.addProduct("P101",1, storage);
        register.addProduct("P102",3, storage);
        register.endSale();
    }
    
}
