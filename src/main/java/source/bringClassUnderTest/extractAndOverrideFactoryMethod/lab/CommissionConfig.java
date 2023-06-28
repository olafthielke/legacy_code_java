package source.bringClassUnderTest.extractAndOverrideFactoryMethod.lab;

public class CommissionConfig {
	
    private int commission;
    private boolean netTax;
    private boolean applyImmediately;

    public int getCommission() {
        return commission;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public boolean isNetTax() {
        return netTax;
    }

    public void setNetTax(boolean netTax) {
        this.netTax = netTax;
    }

    public boolean isApplyImmediately() {
        return applyImmediately;
    }

    public void setApplyImmediately(boolean applyImmediately) {
        this.applyImmediately = applyImmediately;
    }
}
