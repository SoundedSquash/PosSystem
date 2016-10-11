/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wtb_discountstrategy;

/**
 * @author wboyer
 */
public class Customer {
    private String firstName;
    private String lastName;
    private String customerId;

    public Customer(String customerId, String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
        setCustomerId(customerId);
    }

    public final String getFirstName() {
        return firstName;
    }

    public final void setFirstName(String firstName) {
        //Validate
        this.firstName = firstName;
    }

    public final String getLastName() {
        return lastName;
    }

    public final void setLastName(String lastName) {
        //Validate
        this.lastName = lastName;
    }

    public final String getCustomerId() {
        return customerId;
    }

    public final void setCustomerId(String customerId) {
        //Validate
        this.customerId = customerId;
    }
}
