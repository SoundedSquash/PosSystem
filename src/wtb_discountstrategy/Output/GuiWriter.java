package wtb_discountstrategy.Output;

import wtb_discountstrategy.Customer;
import wtb_discountstrategy.LineItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;

/**
 * Created by wboyer on 10/5/2016.
 */
public class GuiWriter implements Writer {

    private static final String QTY = "Qty";
    private static final String PRODUCT = "Product";
    private static final String PRICE = "Price";
    private static final String SUBTOTAL = "Subtotal";
    private static final String DISCOUNT = "Discount";
    private static final String FINAL = "Final";

    private LineItem[] lineItems = new LineItem[0];

    @Override
    public final void write(Customer customer, LineItem[] lineItems) {
        JOptionPane jop = new JOptionPane();

        String productName;
        double productPrice, productSubTotal, productDiscount, runningSubTotal = 0, runningDiscount = 0, runningTotal = 0;
        int productQuantity;
        DecimalFormat df = new DecimalFormat("$#0.00");
        
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn(QTY);
        model.addColumn(PRODUCT);
        model.addColumn(PRICE);
        model.addColumn(SUBTOTAL);
        model.addColumn(DISCOUNT);
        model.addColumn(FINAL);

        for (LineItem li : lineItems) {
        //Get LineItem info.
        productName = li.getProduct().getProductName();
        productQuantity = li.getQuantity();
        productPrice = li.getProduct().getProductPrice();
        productSubTotal = productQuantity * productPrice;
        productDiscount = li.getProduct().getDiscount().getDiscount(productPrice, productQuantity);

            //Add running totals
            runningSubTotal += productSubTotal;
            runningDiscount += productDiscount;
            runningTotal += productSubTotal-productDiscount;

            model.addRow(new Object[]{productQuantity, productName, df.format(productPrice), df.format(productSubTotal), df.format(productDiscount), df.format(productSubTotal-productDiscount)});
        }
        model.addRow(new Object[]{"-----", "------", "Totals:", df.format(runningSubTotal), df.format(runningDiscount), df.format(runningTotal)});
        jop.showMessageDialog(null, new JScrollPane(table));

    }

    @Override
    public final void writeItem(Customer customer, LineItem lineItem) {
        JOptionPane jop = new JOptionPane();

        String productName;
        double productPrice, productSubTotal, productDiscount;
        int productQuantity;
        DecimalFormat df = new DecimalFormat("$#0.00");

        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        model.addColumn(QTY);
        model.addColumn(PRODUCT);
        model.addColumn(PRICE);
        model.addColumn(SUBTOTAL);
        model.addColumn(DISCOUNT);
        model.addColumn(FINAL);

        addToLineItems(lineItem);

        for (LineItem li : lineItems) {

            //Get LineItem info.
            productName = li.getProduct().getProductName();
            productQuantity = li.getQuantity();
            productPrice = li.getProduct().getProductPrice();
            productSubTotal = productQuantity * productPrice;
            productDiscount = li.getProduct().getDiscount().getDiscount(productPrice, productQuantity);
        
            //Create output
            model.addRow(new Object[]{productQuantity, productName, df.format(productPrice), df.format(productSubTotal), df.format(productDiscount), df.format(productSubTotal - productDiscount)});
        }
        jop.showMessageDialog(null, new JScrollPane(table));
    }

    private void addToLineItems(LineItem item) {
        LineItem[] temp = new LineItem[lineItems.length + 1];

        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);

        temp[temp.length - 1] = item;
        lineItems = temp;
        temp = null;
    }
}
