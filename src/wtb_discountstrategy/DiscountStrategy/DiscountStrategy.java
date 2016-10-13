/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy.DiscountStrategy;

/**
 * @author wboyer
 */
public interface DiscountStrategy {

    double getDiscount(double price, int quantity);

    double getDiscount();
    
    String getDiscountDescription();

    void setDiscount(double discount);

}
