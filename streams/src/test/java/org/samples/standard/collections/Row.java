package org.samples.standard.collections;

/**
 *
 * @author mmontel
 */
public class Row {

    private String region;
    private String gender;
    private String product;
    private double price;
    private int units;

    public Row(String region, String gender, String product, int units, double price) {
        this.region = region;
        this.gender = gender;
        this.price = price;
        this.units = units;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    @Override
    public String toString() {
        return "Row{" + "region=" + region + ", gender=" + gender + ", product=" + product + ", price=" + price + ", units=" + units + '}';
    }

}
