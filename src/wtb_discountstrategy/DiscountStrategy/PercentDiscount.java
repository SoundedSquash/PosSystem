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
    public final double getDiscount(double price, int quantity) {
        return price * quantity * discount;
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

    @Override
    public String getDiscountDescription() {
        return (getDiscount() * 100) + "% discount.";
    }
}
