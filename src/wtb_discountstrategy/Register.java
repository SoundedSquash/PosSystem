/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy;

import wtb_discountstrategy.Storage.Storage;

/**
 *
 * @author wboyer
 */
public class Register {
    private Receipt receipt;
    private Storage storage;

    public final void startNewSale(String customerId, Storage storage) {
        receipt = new Receipt(customerId, storage);
        this.storage = storage;
    }

    public final void addProduct(String productId, int quantity, Storage storage) {
        receipt.addProduct(productId, quantity, storage);
    }

    public final void endSale() {
        receipt.printReceipt();
    }
    
}
