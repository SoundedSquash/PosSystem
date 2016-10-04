package wtb_discountstrategy;

/**
 * @author wboyer
 */

public class InternalDatabase implements Storage {
    private Customer[] customers = {
        new Customer("C100", "Sally", "Jones"),
        new Customer("C101", "Bob", "Smith"),
        new Customer("C102", "John", "Doe")
    };
    private Product[] products = {
        new Product("P100", "Jeans", 4.99, new QuantityDiscount(0.30, 3)),
        new Product("P101", "Football", 9.99, new PercentDiscount(0.10)),
        new Product("P101", "T.V.", 349.99, new PercentDiscount(0.25))
    };
    
    @Override
    public Customer findCustomerById(String customerId){
        Customer foundCustomer = null;
        
        for(Customer c : customers){
            if(customerId.equals(c.getCustomerId())){
                foundCustomer = c;
                break;
            }
        }
        return foundCustomer;
    }
    
    @Override
    public Product findProductById(String productId){
        Product foundProduct = null;
        
        for(Product p : products){
            if(productId.equals(p.getProductId())){
                foundProduct = p;
                break;
            }
        }
        return foundProduct;
    }
}
