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
public class Receipt {
    private Customer customer;
    private Storage storage;
    private LineItem[] lineItems;

    public Receipt(String customerId, Storage storage) {
        this.storage = storage;
        storage.findCustomerById(customerId);
        lineItems = new LineItem[0];
    }

    void addProduct(String productId, int quantity, Storage storage) {
        LineItem item = new LineItem(productId, quantity, storage);
        addToLineItems(item);
    }
    
    private void addToLineItems(LineItem item){
        LineItem[] temp = new LineItem[lineItems.length + 1];
        
        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);
        
        temp[temp.length - 1] = item;
        lineItems = temp;
        temp = null;
    }
    
    public void printReceipt(){
        for(LineItem li : lineItems){
            System.out.println(li.getProduct().getProductName() + ", " + li.getQuantity());
        }
    }
}
