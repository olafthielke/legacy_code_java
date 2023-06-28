package source.bringClassUnderTest.passNull.lab;

public class CustomerOrderService {
    private OrderService orderService;

    // Want to bring CustomerOrderService under test so 
    // we can bring method createCustomerOrder() under test.
    public CustomerOrderService(int config) {
        if (config <= 3) {
            orderService = new OrderService(config);

            int isValidInit = this.orderService.initialise();
            if (isValidInit == -1) {
                this.orderService.prepopulate();
            }
        }
    }

    public void createCustomerOrder(Customer customer) {
        // Create and save a customer order via the OrderService.

        // ...
    }
}
