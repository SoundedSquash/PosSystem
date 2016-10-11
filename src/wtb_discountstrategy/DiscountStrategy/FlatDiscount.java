package wtb_discountstrategy.DiscountStrategy;

/**
 * @author wboyer
 */

public class FlatDiscount implements DiscountStrategy {
    private double discount = 1;

    public FlatDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public final double getDiscount(double price, int quantity) {
        return (price - (price - discount)) * quantity;
    }

    @Override
    public final double getDiscount() {
        return discount;
    }

    @Override
    public final void setDiscount(double discount) {
        //Validate
        this.discount = discount;
    }
}
