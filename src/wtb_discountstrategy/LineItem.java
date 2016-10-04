package wtb_discountstrategy;

import wtb_discountstrategy.Storage.Storage;

/**
 * @author wboyer
 */

public class LineItem {
    private Product product;
    private int quantity;

    public LineItem(String productId, int quantity, Storage storage) {
        product = storage.findProductById(productId);
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
