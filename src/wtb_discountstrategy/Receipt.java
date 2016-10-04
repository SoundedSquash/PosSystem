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
public class Receipt {
    private Customer customer;
    private Storage storage;

    public Receipt(String customerId, Storage storage) {
        this.storage = storage;
        storage.findCustomerById(customerId);
    }
    
}
