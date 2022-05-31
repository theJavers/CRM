package classes;

import enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lead {
    private final int id;
    private static int counter = 1;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private static List<Lead> allLeads = new ArrayList<>();

    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = counter++;
        setPhoneNumber(phoneNumber);
        setName(name);
        setEmail(email);
        setCompanyName(companyName);
    }

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public static List<Lead> getAllLeads() {
        return allLeads;
    }

    public static void addLeadToList(Lead lead) {
        allLeads.add(lead);
    }

    public static void removeLead(Lead lead) {
        allLeads.remove(lead);
    }


    public static void createLeadWithInput() {

        Scanner input = new Scanner(System.in);
        String newInput = input.nextLine().toLowerCase();

        if (newInput.equals("new lead")) {
            System.out.println("Introduce name");
            String inputName = input.nextLine().toLowerCase();
            System.out.println("Introduce phone number");
            String inputPhoneNumber = input.nextLine().toLowerCase();
            System.out.println("Introduce email");
            String inputEmail = input.nextLine().toLowerCase();
            System.out.println("Introduce company name");
            String inputCompanyName = input.nextLine().toLowerCase();
            Lead lead = new Lead(inputName, inputPhoneNumber, inputEmail, inputCompanyName);
            addLeadToList(lead);
            System.out.println("Lead created successfully: " + lead);

        } else {
            System.out.println("Please try again with 'new lead'");
            createLeadWithInput();
        }
    }

    public static void showAllLeads() {
        Scanner input = new Scanner(System.in);
        String newInput = input.nextLine().toLowerCase();
        System.out.println("Write 'show leads' to get all leads list");
        if (newInput.equals("show leads")) {
            for (Lead lead : allLeads) {
                System.out.println("Lead id: " + lead.getId() + "\n Lead name: " + lead.getName() + "\n =======");
            }
        } else {
            System.err.println("Please try again with command 'show leads'");
            showAllLeads();
        }
    }

    public void lookupActualLeadsId() {
        Scanner input = new Scanner(System.in);
        String newInput = input.nextLine().toLowerCase();
        if (newInput.equals("lookup lead id")) {
            System.out.println(getId());
        } else {
            System.err.println("Please, try again with 'lookup lead id'");
            lookupActualLeadsId();
        }

    }

    public static void convertLeadToOpportunity(List<Lead> leads) {

        Scanner input = new Scanner(System.in);
        String newInput = input.nextLine().toLowerCase();
        int counter = 0;
        while (counter < leads.size()) {
            for (Lead lead : leads) {
                String num = String.valueOf(lead.getId());
                counter++;
                if (newInput.equals("convert " + num)) {
                    System.out.println("Lead found: " + lead.getName());
                    Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
                    System.out.println("New Contact created from this lead: " + contact);
                    Opportunity opportunity = new Opportunity(contact, Status.OPEN);
                    System.out.println("New Opportunity created from this lead: " + opportunity);
                    // CREAR ACCOUNT
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Lead{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", companyName='" + companyName + '\'' +
                '}';
    }
}