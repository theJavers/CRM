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

import static classes.Opportunity.*;
import static enums.Status.*;

public class Lead {
    private final int id;
    private static int counter = 1;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;
    private static List<Lead> allLeads = new ArrayList();

    // crear list of opps
    private static List<Opportunity> allOps = new ArrayList<>();

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

    public static List<Lead> removeLead(Lead lead) {
        if(lead == null){
            throw new IllegalArgumentException();
        }
        allLeads.remove(lead);
        return allLeads;
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

    // Metodo que printa todas las opportunities
    public static void listOfOpportunities(){
        Scanner input = new Scanner(System.in);
        String newInput = input.nextLine().toLowerCase();
        if(newInput.equals("show all opportunities")){
            for(Opportunity a : allOps){
                System.out.println(allOps.get(allOps.indexOf(a)));
            }
        }

    }

    //metodo que mostra opportunidad por id
    public static void listOportunitiesId() {
        Scanner input = new Scanner(System.in);
        System.out.println("Type lookup opportunity + number");
        String newInput = input.nextLine().toLowerCase();
        for (Opportunity opp : allOps) {
            String num = String.valueOf(opp.getOpId());
            if(newInput.equals("lookup opportunity "+ num)){
                System.out.println(opp.toString());
            }
            }
        }

        //********************************************
        public static void closeOpportunity(){
            //Sara types “close-lost 24” and the CRM changes the status of opportunity 24 to “CLOSED-LOST”
            //Opportunity status can be edited using the command “close-lost id” or “close-won id” where “id”
            // is the id of the Opportunity that should be closed.
            Scanner input = new Scanner(System.in);
            String closOpInput = input.nextLine().toLowerCase();
            for(Opportunity opp : allOps){
                String num = String.valueOf(opp.getOpId());
                if(closOpInput.equals("close-lost " + num)){
                    opp.setStatus(CLOSE);
                    System.out.println("Opportunity is CLOSED-LOST");
                }else if(closOpInput.equals("close-won" + num)){
                    opp.setStatus(CLOSEWON);
                }
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

                // Añadimos la opportunity a la lista de opps
                allOps.add(opportunity);
                System.out.println("New Opportunity created from this lead: " + opportunity);

                // Creamos account

                Account account = new Account(lead.getCompanyName(), contact, opportunity);
                System.out.println("New account ACCOUNT from this lead: " + account);
                //removeLead(lead);
            }
        }
    }

    public String toString() {
        return "Lead{id=" + this.id + ", name='" + this.name + "', phoneNumber='" + this.phoneNumber + "', email='" + this.email + "', companyName='" + this.companyName + "'}";
    }
}
