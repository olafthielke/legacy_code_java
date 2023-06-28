package source.refactor.extractSmallMethod;


public interface CustomerRepository {
    Customer getCustomer(String email);

    void saveCustomer(Customer customer);
}
