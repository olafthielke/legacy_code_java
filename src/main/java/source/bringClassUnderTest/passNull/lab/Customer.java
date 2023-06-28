package source.bringClassUnderTest.passNull.lab;

public class Customer {
    private String number;
    private String name;
    private CustomerCategory category;
    private String address;
    private int loyaltyScore;
    private boolean manualCheckDone;
    private boolean createdByAdmin;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CustomerCategory getCategory() {
        return category;
    }

    public void setCategory(CustomerCategory category) {
        this.category = category;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getLoyaltyScore() {
        return loyaltyScore;
    }

    public void setLoyaltyScore(int loyaltyScore) {
        this.loyaltyScore = loyaltyScore;
    }

    public boolean isManualCheckDone() {
        return manualCheckDone;
    }

    public void setManualCheckDone(boolean manualCheckDone) {
        this.manualCheckDone = manualCheckDone;
    }

    public boolean isCreatedByAdmin() {
        return createdByAdmin;
    }

    public void setCreatedByAdmin(boolean createdByAdmin) {
        this.createdByAdmin = createdByAdmin;
    }
}
