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
}
