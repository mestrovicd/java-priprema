package hr.java.production.model;

import java.math.BigDecimal;
import java.security.cert.CertificateRevokedException;

public class Item extends NamedEntity implements Edible {
    private Category category;
    private BigDecimal width;
    private BigDecimal height;
    private BigDecimal length;
    private BigDecimal productionCost;
    private BigDecimal sellingPrice;
    public Item(String name, Category category, BigDecimal width, BigDecimal height, BigDecimal length, BigDecimal productionCost, BigDecimal sellingPrice) {
        super(name);
        this.category = category;
        this.width = width;
        this.height = height;
        this.length = length;
        this.productionCost = productionCost;
        this.sellingPrice = sellingPrice;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public BigDecimal getWidth() {
        return width;
    }
    public void setWidth(BigDecimal width) {
        this.width = width;
    }
    public BigDecimal getHeight() {
        return height;
    }
    public void setHeight(BigDecimal height) {
        this.height = height;
    }
    public BigDecimal getLength() {
        return length;
    }
    public void setLength(BigDecimal length) {
        this.length = length;
    }
    public BigDecimal getProductionCost() {
        return productionCost;
    }
    public void setProductionCost(BigDecimal productionCost) {
        this.productionCost = productionCost;
    }
    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }
    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    @Override
    public int calculateKilocalories() {
        return 0;
    }

    @Override
    public BigDecimal calculatePrice() {
        return null;
    }
}
