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

    public Product(String productId, String productName, double productPrice, DiscountStrategy discount) {
        setProductName(productName);
        setProductPrice(productPrice);
        setProductId(productId);
        setDiscount(discount);
    }

    public final DiscountStrategy getDiscount() {
        return discount;
    }

    public final void setDiscount(DiscountStrategy discount) {
        //Validate
        this.discount = discount;
    }

    public final String getProductName() {
        return productName;
    }

    public final void setProductName(String productName) {
        //Validate
        this.productName = productName;
    }

    public final double getProductPrice() {
        return productPrice;
    }

    public final void setProductPrice(double productPrice) {
        //Validate
        this.productPrice = productPrice;
    }

    public final String getProductId() {
        return productId;
    }

    public final void setProductId(String productId) {
        //Validate
        this.productId = productId;
    }
}
