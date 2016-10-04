package wtb_discountstrategy.DiscountStrategy;

/**
 * @author wboyer
 */

public class PercentDiscount implements DiscountStrategy {
    private double discount = 0.10;

    public PercentDiscount(double discount) {
        this.discount = discount;
    }
    
    @Override
    public double getDiscount(double price, int quantity){
        return price * quantity * discount;
    }

    @Override
    public double getDiscount() {
        return discount;
    }

    @Override
    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
