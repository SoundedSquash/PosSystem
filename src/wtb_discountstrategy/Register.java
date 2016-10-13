/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy;

import wtb_discountstrategy.Output.Writer;
import wtb_discountstrategy.Storage.Storage;

/**
 * @author wboyer
 */
public class Register {
    private Receipt receipt;

    public final void startNewSale(String customerId, Storage storage, Writer writer) {
        receipt = new Receipt(customerId, storage, writer);
    }

    public final void addProduct(String productId, int quantity, Storage storage) {
        receipt.addProduct(productId, quantity, storage);
        receipt.printItem();
    }

    public final void endSale(Writer writer) {
        receipt.printReceipt(writer);
    }

}
