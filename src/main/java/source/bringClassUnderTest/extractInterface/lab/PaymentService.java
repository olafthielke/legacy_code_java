package source.bringClassUnderTest.extractInterface.lab;

//Consumer of PaymentChannel
public class PaymentService {

	private PaymentChannel paymentChannel;
	
	public PaymentService() throws Exception {
		
	     this.paymentChannel = new PaymentChannel();
	}
}
