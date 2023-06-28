package source.refactor.changeLongComplicatedMethod;

import java.math.BigDecimal;
import java.util.List;

public class DbInvoice {
    private int id;
    private int no;
    private BigDecimal total;
    private List<DbInvoiceLine> lines;
    private boolean updateable;
    private BigDecimal gstAmount;
    private boolean gstApplies;
    private BigDecimal gstRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<DbInvoiceLine> getLines() {
        return lines;
    }

    public void setLines(List<DbInvoiceLine> lines) {
        this.lines = lines;
    }

    public boolean isUpdateable() {
        return updateable;
    }

    public void setUpdateable(boolean updateable) {
        this.updateable = updateable;
    }

    public BigDecimal getGstAmount() {
        return gstAmount;
    }

    public void setGstAmount(BigDecimal gstAmount) {
        this.gstAmount = gstAmount;
    }

    public boolean isGstApplies() {
        return gstApplies;
    }

    public void setGstApplies(boolean gstApplies) {
        this.gstApplies = gstApplies;
    }

    public BigDecimal getGstRate() {
        return gstRate;
    }

    public void setGstRate(BigDecimal gstRate) {
        this.gstRate = gstRate;
    }
}
