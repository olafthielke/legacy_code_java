package source.bringClassUnderTest.extractAndOverrideFactoryMethod.lab;

public class TransactionPersistor {
	
    private MongoDbConnector mongoDb;
    private CommissionConfig cconfig;

    public TransactionPersistor() {
    	
        mongoDb = new MongoDbConnector(Configuration.getConnectionString());

        CommissionConfig commissionConfig = new CommissionConfig();
        commissionConfig.setCommission(20);  // 20%
        commissionConfig.setNetTax(false);
        commissionConfig.setApplyImmediately(true);
        cconfig = commissionConfig;
    }

    
    public int save(Transaction tx) {
        MongoDbTransaction dbTx = new MongoDbTransaction(tx.getTransactionId(), cconfig.getCommission());
        dbTx.setBuyer(tx.getPurchaser());
        dbTx.setSeller(tx.getMerchant());

        // ...

        return mongoDb.saveTx(dbTx);
    }
}
