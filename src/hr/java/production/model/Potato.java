package hr.java.production.model;

import java.math.BigDecimal;

public class Potato extends Item implements Edible{
    private static final int CALORIES_PER_KG = 80;
    private BigDecimal weight;

    public Potato(String name, Category category, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice, BigDecimal weight) {
        super(name, category, width, height, length, productionCost, sellingPrice);
        this.weight = weight;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    @Override
    public int calculateKilocalories() {
        return weight.multiply(BigDecimal.valueOf(CALORIES_PER_KG)).intValue();
    }

    @Override
    public BigDecimal calculatePrice() {
        return weight.multiply(getSellingPrice());
    }
}
