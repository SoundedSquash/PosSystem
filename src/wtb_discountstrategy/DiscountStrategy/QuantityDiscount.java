package wtb_discountstrategy.DiscountStrategy;

/**
 * @author wboyer
 */

public class QuantityDiscount implements DiscountStrategy {
    private double discount = 0.15;
    private int minQuantity = 5;

    public QuantityDiscount(double discount, int minQuantity) {
        this.discount = discount;
        this.minQuantity = minQuantity;
    }
    
    @Override
    public double getDiscount(double price, int quantity){
        double discountAmount = 0;
        
        if(quantity >= minQuantity){
            discountAmount = price * quantity * discount;            
        }
        
        return discountAmount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public int getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(int minQuantity) {
        this.minQuantity = minQuantity;
    }
}
