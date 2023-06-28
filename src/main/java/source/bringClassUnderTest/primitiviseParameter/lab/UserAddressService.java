package source.bringClassUnderTest.primitiviseParameter.lab;

public class UserAddressService {

	private AddressLookupService addressLookup;
	
    public UserAddressService() {
        this.addressLookup = new AddressLookupService();
    }
}
