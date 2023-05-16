package core.model;

import javax.validation.constraints.NotBlank;

public class Customer {
    private int customerId;
    @NotBlank(message="The name field must not be blank.")
    private String name;
    @NotBlank(message="The address field must not be blank.")
    private String address;
    @NotBlank(message="The accountType field must not be blank.")
    private String accountType;

    public Customer(int customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }


    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
}

