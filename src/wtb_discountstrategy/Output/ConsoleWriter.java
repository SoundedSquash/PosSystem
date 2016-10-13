package wtb_discountstrategy.Output;

import wtb_discountstrategy.Customer;
import wtb_discountstrategy.LineItem;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wboyer on 10/5/2016.
 */
public class ConsoleWriter implements Writer {

    private static final String TABLE_FORMAT = "%-5s %-10s %-10s %-10s %-10s %-10s \n";
    private static final String QTY = "Qty";
    private static final String PRODUCT = "Product";
    private static final String PRICE = "Price";
    private static final String SUBTOTAL = "Subtotal";
    private static final String DISCOUNT = "Discount";
    private static final String FINAL = "Final";
    private static final String STRING_EMPTY = "";
    private static final String HYPHEN_5 = "-----";
    private static final String HYPHEN_10 = "----------";

    private LineItem[] lineItems = new LineItem[0];

    @Override
    public final void write(Customer customer, LineItem[] lineItems){
        String productName;
        double productPrice, productSubTotal, productDiscount, runningSubTotal = 0, runningDiscount = 0, runningTotal = 0;
        int productQuantity;
        DecimalFormat df = new DecimalFormat("$#0.00");
        
        // sample
        StringBuilder sb = new StringBuilder(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date()));
        sb.append("\n");
        System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println();
    

        //Create header
        System.out.println(new SimpleDateFormat("MM/dd/yyyy hh:mm:ss a").format(new Date()));
        System.out.println();
        System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());
        System.out.println();
        //Headings
        System.out.printf(TABLE_FORMAT, QTY, PRODUCT, PRICE, SUBTOTAL, DISCOUNT, FINAL);
        System.out.printf(TABLE_FORMAT, HYPHEN_5, HYPHEN_10, HYPHEN_10, HYPHEN_10, HYPHEN_10, HYPHEN_10);
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

            //Create output
            System.out.printf(TABLE_FORMAT, productQuantity, productName, df.format(productPrice), df.format(productSubTotal), df.format(productDiscount), df.format(productSubTotal-productDiscount));
        }
        //Footers
        System.out.printf(TABLE_FORMAT, HYPHEN_5, HYPHEN_10, HYPHEN_10, HYPHEN_10, HYPHEN_10, HYPHEN_10);
        System.out.printf(TABLE_FORMAT, STRING_EMPTY, STRING_EMPTY, "Totals:", df.format(runningSubTotal), df.format(runningDiscount), df.format(runningTotal));
        System.out.println();
        System.out.println("Thanks for shopping at Kohl's!");
    }

    @Override
    public final void writeItem(Customer customer, LineItem lineItem) {
        String productName;
        double productPrice, productSubTotal, productDiscount;
        int productQuantity;
        DecimalFormat df = new DecimalFormat("$#0.00");

        addToLineItems(lineItem);

        if (lineItems.length == 1) {
            //Headings
            System.out.printf(TABLE_FORMAT, QTY, PRODUCT, PRICE, SUBTOTAL, DISCOUNT, FINAL);
            System.out.printf(TABLE_FORMAT, HYPHEN_5, HYPHEN_10, HYPHEN_10, HYPHEN_10, HYPHEN_10, HYPHEN_10);
        }

        LineItem li = lineItems[lineItems.length-1];

            //Get LineItem info.
            productName = li.getProduct().getProductName();
            productQuantity = li.getQuantity();
            productPrice = li.getProduct().getProductPrice();
            productSubTotal = productQuantity * productPrice;
            productDiscount = li.getProduct().getDiscount().getDiscount(productPrice, productQuantity);
            //Create output
            System.out.printf(TABLE_FORMAT, productQuantity, productName, df.format(productPrice), df.format(productSubTotal), df.format(productDiscount), df.format(productSubTotal - productDiscount));
    }

    private void addToLineItems(LineItem item) {
        LineItem[] temp = new LineItem[lineItems.length + 1];

        System.arraycopy(lineItems, 0, temp, 0, lineItems.length);

        temp[temp.length - 1] = item;
        lineItems = temp;
        temp = null;
    }
}
