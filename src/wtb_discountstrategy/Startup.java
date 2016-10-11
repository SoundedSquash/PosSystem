/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy;

import wtb_discountstrategy.Output.ConsoleWriter;
import wtb_discountstrategy.Output.GuiWriter;
import wtb_discountstrategy.Output.Writer;
import wtb_discountstrategy.Storage.InternalDatabase;
import wtb_discountstrategy.Storage.Storage;

/**
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
        Writer writer = new ConsoleWriter();
        Writer lineWriter = new ConsoleWriter();

        //Customer #C100
        register.startNewSale("C100", storage);
        register.addProduct("P100", 2, storage, lineWriter);
        register.addProduct("P101", 1, storage, lineWriter);
        register.addProduct("P102", 3, storage, lineWriter);
        register.addProduct("P103", 4, storage, lineWriter);
        register.addProduct("P104", 1, storage, lineWriter);
        register.addProduct("P105", 1, storage, lineWriter);
        register.endSale(writer);
    }

}
