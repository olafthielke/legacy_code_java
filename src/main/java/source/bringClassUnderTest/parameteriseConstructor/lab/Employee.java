package source.bringClassUnderTest.parameteriseConstructor.lab;


public class Employee {
    private String firstName;
    private String lastName;
    private String emailAddress;
    private int salary;
    private DayOfTheWeek paymentDate;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public DayOfTheWeek getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(DayOfTheWeek paymentDate) {
        this.paymentDate = paymentDate;
    }
}

enum DayOfTheWeek {
    Monday,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday,
    Sunday
}
