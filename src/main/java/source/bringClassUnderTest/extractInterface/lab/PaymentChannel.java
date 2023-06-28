package source.bringClassUnderTest.extractInterface.lab;

public class PaymentChannel {
	
    private PaypalMoneyTransfer transfer;
    
    public PaymentChannel() throws Exception {
    	
        transfer = new PaypalMoneyTransfer();

        transfer.configurePaypal(true, 5, "PENDING");  // 3 means same-day payment.

        // ...
    }
}
