/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy.Storage;

import wtb_discountstrategy.Customer;
import wtb_discountstrategy.Product;

/**
 * @author wboyer
 */
public interface Storage {

    public abstract Customer findCustomerById(String customerId);
    public abstract Product findProductById(String productId);
    
}
