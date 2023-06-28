package source.bringClassUnderTest.extractAndOverrideFactoryMethod.lab;

import java.util.UUID;

public class MongoDbTransaction {
    private UUID guid;
    private String buyer;
    private String seller;
    private double totalAmount;
    private String transactionId;
    private String affiliateId;
    private double commission;
    private String affiliateName;

    public MongoDbTransaction(UUID id, int commissionPercent) {
        if (id == null) {
            id = UUID.randomUUID();
        }
        guid = id;
        commission *= (1 + commissionPercent);
    }

    public UUID getGuid() {
        return guid;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getAffiliateId() {
        return affiliateId;
    }

    public void setAffiliateId(String affiliateId) {
        this.affiliateId = affiliateId;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public String getAffiliateName() {
        return affiliateName;
    }

    public void setAffiliateName(String affiliateName) {
        this.affiliateName = affiliateName;
    }
}
