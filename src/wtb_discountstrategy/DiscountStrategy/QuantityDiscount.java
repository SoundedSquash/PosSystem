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
    public final double getDiscount(double price, int quantity) {
        double discountAmount = 0;

        if (quantity >= minQuantity) {
            discountAmount = price * quantity * discount;
        }

        return discountAmount;
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

    public final int getMinQuantity() {
        return minQuantity;
    }

    public final void setMinQuantity(int minQuantity) {
        //Validate
        this.minQuantity = minQuantity;
    }

    @Override
    public String getDiscountDescription() {
        return "Buy " + getMinQuantity() + ", get " + (getDiscount() * 100) + "% discount.";
    }
}
