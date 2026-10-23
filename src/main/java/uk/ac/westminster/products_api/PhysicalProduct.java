package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product{
    private double weightKG;
    private String dimension;

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
}
