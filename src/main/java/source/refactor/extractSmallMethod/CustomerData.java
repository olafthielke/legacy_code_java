package source.refactor.extractSmallMethod;


public class CustomerData {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String validate() {
        if (firstName == null || firstName.trim().isEmpty()) {
            return "No customer first name.";
        }

        if (lastName == null || lastName.trim().isEmpty()) {
            return "No customer last name.";
        }

        if (emailAddress == null || emailAddress.trim().isEmpty()) {
            return "No customer email address.";
        }

        return null;
    }
}
