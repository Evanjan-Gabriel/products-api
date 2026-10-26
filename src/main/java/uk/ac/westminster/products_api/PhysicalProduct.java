package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable{
    private double weightKG;
    private String dimension;
    private double discountedPrice;

    public PhysicalProduct(){
    }
    public PhysicalProduct(Long id, String name, double price,
                           double weightKG,
                           String dimension) {
        super(id, name, price);
        this.weightKG = weightKG;
        this.dimension = dimension;
    }

    public double getWeightKG() {
        return weightKG;
    }
    public void setWeightKG(double weightKG) {
        this.weightKG = weightKG;
    }

    public String getDimension() {
        return dimension;
    }
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }



    //@Override
    public String getSummary(){
        return "Product Name: "+getName()+" | Price: "+getPrice()+
                " | Weight: "+weightKG;
    }

    @Override
    public void applyDiscount (double rate){
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice()*(1 - capped);
    };

    @Override
    public double getDiscountedPrice(){
        return discountedPrice;
    }


}
