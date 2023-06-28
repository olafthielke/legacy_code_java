package source.bringClassUnderTest.extractInterface.demo;

//Consumer of NotificationService
public class CustomerNotifier {

	private NotificationService notificationService;
	
	public CustomerNotifier() throws Exception {
		
	     this.notificationService = new NotificationService();
	}
}
