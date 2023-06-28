package source.bringClassUnderTest.extractInterface.demo;


public class NotificationService {
	
    private AzureMessageStore notifications;

    
    public NotificationService() throws Exception {
        
    	notifications = new AzureMessageStore();
        
        notifications.init("active", 4);
    }
}
