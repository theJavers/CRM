//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package classes;

import enums.Status;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Lead {
    private final int id;
    private static int counter = 1;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private static List<Lead> allLeads = new ArrayList();

    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = counter++;
        this.setPhoneNumber(phoneNumber);
        this.setName(name);
        this.setEmail(email);
        this.setCompanyName(companyName);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public static List<Lead> getAllLeads() {
        return allLeads;
    }

    public static void addLeadToList(Lead lead) {
        if(lead == null){
            throw new IllegalArgumentException();
        }
        allLeads.add(lead);
    }

    public static void removeLead(Lead lead) {
        if(lead == null){
            throw new IllegalArgumentException();
        }
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
        if (newInput.equals("show leads")) {
            Iterator var2 = allLeads.iterator();

            while(var2.hasNext()) {
                Lead lead = (Lead)var2.next();
                PrintStream var10000 = System.out;
                int var10001 = lead.getId();
                var10000.println("Lead id: " + var10001 + "\n Lead name: " + lead.getName() + "\n =======");
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
            System.out.println(this.getId());
        } else {
            System.err.println("Please, try again with 'lookup lead id'");
            this.lookupActualLeadsId();
        }

    }

    public static void convertLeadToOpportunity(List<Lead> leads) {
        Scanner input = new Scanner(System.in);
        String newInput = input.nextLine().toLowerCase();
        Iterator var3 = leads.iterator();

        while(var3.hasNext()) {
            Lead lead = (Lead)var3.next();
            String num = String.valueOf(lead.getId());
            if (newInput.equals("convert " + num)) {
                System.out.println("Lead found: " + lead.getName());
                Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
                System.out.println("New Contact created from this lead: " + contact);
                Opportunity opportunity = new Opportunity(contact, Status.OPEN);
                System.out.println("New Opportunity created from this lead: " + opportunity);
                Account account = new Account(lead.getCompanyName(), contact, opportunity);
                System.out.println("New account ACCOUNT from this lead: " + account);
            }
        }

    }

    public String toString() {
        return "Lead{id=" + this.id + ", name='" + this.name + "', phoneNumber='" + this.phoneNumber + "', email='" + this.email + "', companyName='" + this.companyName + "'}";
    }
}
