package wtb_discountstrategy;

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
