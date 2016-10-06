/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy;

import wtb_discountstrategy.Storage.Storage;

import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;

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
        customer = storage.findCustomerById(customerId);
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
        String productName;
        double productPrice, productSubTotal, productDiscount;
        int productQuantity;
        DecimalFormat df = new DecimalFormat("$#0.00");
        //Create header
        System.out.println(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date()));
        System.out.println();
        System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println();
        //Heading
        System.out.printf("%-5s %-10s %-10s %-10s %-10s \n", "Qty", "Product", "Price", "Subotal", "Discount");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s \n", "-----", "----------", "----------", "----------", "----------");
        for(LineItem li : lineItems){
            productName = li.getProduct().getProductName();
            productQuantity = li.getQuantity();
            productPrice = li.getProduct().getProductPrice();
            productSubTotal = productQuantity * productPrice;
            productDiscount = li.getProduct().getDiscount().getDiscount(productPrice,productQuantity);

            System.out.printf("%-5d %-10s %-10s %-10s %-10s \n", productQuantity, productName, df.format(productPrice), df.format(productSubTotal), df.format(productDiscount));
        }
        System.out.printf("%-5s %-10s %-10s %-10s %-10s \n", "-----", "----------", "----------", "----------", "----------");
        System.out.printf("%-5s %-10s %-10s %-10s %-10s \n", "", "", "Total:", "----------", "----------");
    }
}
