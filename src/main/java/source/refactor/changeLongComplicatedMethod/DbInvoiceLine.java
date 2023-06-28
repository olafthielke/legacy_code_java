package source.refactor.changeLongComplicatedMethod;

import java.math.BigDecimal;

public class DbInvoiceLine {

    private int invoiceLineId;
    private int invoiceNumber;
    private int productId;
    private int lineNumber;
    private BigDecimal subtotal;
    private int quantity;
    private String productName;
    private String SKU;

    public int getInvoiceLineId() {
        return this.invoiceLineId;
    }

    public void setInvoiceLineId(int invoiceLineId) {
        this.invoiceLineId = invoiceLineId;
    }

    public int getInvoiceNumber() {
        return this.invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public int getProductId() {
        return this.productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public BigDecimal getSubtotal() {
        return this.subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSKU() {
        return this.SKU;
    }

    public void setSKU(String sku) {
        this.SKU = sku;
    }
}
