package source.bringMethodUnderTest.extractAndOverride.lab;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal unitPrice;

    public Product(String name, BigDecimal unitPrice) {
    	this.name = name;
    	this.unitPrice = unitPrice;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
