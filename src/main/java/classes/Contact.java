package classes;

public class Contact extends Lead {
    private final int contactId;
    private static int counter = 1;
    public Contact(String name, String phoneNumber, String email, String companyName) {
        super(name, phoneNumber, email, companyName);
        this.contactId = counter++;
    }

    public int getContactId() {
        return contactId;
    }


    @Override
    public String toString() {
        return "Contact{" +
                "id=" + this.contactId +
                ", name='" + this.getName() + '\'' +
                ", phoneNumber='" + this.getPhoneNumber() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", companyName='" + this.getCompanyName() + '\'' +
                '}';
    }


}
