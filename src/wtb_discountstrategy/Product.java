package wtb_discountstrategy;

import wtb_discountstrategy.DiscountStrategy.DiscountStrategy;

/**
 * @author wboyer
 */

public class Product {
    private String productName;
    private double productPrice;
    private String productId;
    private DiscountStrategy discount;

    public Product( String productId, String productName, double productPrice, DiscountStrategy discount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.productId = productId;
        this.discount = discount;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    
}
