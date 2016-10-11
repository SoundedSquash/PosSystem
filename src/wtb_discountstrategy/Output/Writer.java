package wtb_discountstrategy.Output;

import wtb_discountstrategy.Customer;
import wtb_discountstrategy.LineItem;

/**
 * Created by wboyer on 10/5/2016.
 */
public interface Writer {
    void write(Customer customer, LineItem[] lineItems);

    void writeItem(Customer customer, LineItem li);
}
