package wtb_discountstrategy;

import wtb_discountstrategy.DiscountStrategy.NoDiscount;
import wtb_discountstrategy.Storage.Storage;

/**
 * @author wboyer
 */

public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(String productId, int quantity, Storage storage) {
        Product tempProduct = storage.findProductById(productId);

        setProduct(tempProduct);
        setQuantity(quantity);
    }

    public final Product getProduct() {
        return product;
    }

    public final void setProduct(Product product) {
        if (product == null){
            //Can't find product. Give empty product to prevent nasty error.
            product = new Product("N/A", "N/A", 0, new NoDiscount());
        }
        this.product = product;
    }

    public final int getQuantity() {
        return quantity;
    }

    public final void setQuantity(int quantity) {
        //Validate
        this.quantity = quantity;
    }
}
