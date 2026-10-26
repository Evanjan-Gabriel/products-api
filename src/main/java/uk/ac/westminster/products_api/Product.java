package uk.ac.westminster.products_api;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(DigitalProduct.class),
        @JsonSubTypes.Type(PhysicalProduct.class)
})

public abstract class Product {
//    public Long id;
//    public String name;
//    public double price;

    private Long id;
    private String name;
    private double price;

    public Product(){}

    public Product(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId(){ return id; }

    //without get method for each field there is nothing for it to call, so the field is skipped
    //we have to be cautious with this because this kind of bug produces no error messages
    public String getName() { return name; }

    public double getPrice(){ return price; }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public abstract String getSummary();

    public abstract void applyDiscount(double rate);

    public abstract double getDiscountedPrice();
}
