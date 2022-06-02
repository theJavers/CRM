import classes.Account;
import classes.Contact;
import classes.Lead;
import classes.Opportunity;
import enums.Industry;
import enums.Products;
import enums.Status;

import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Methods {

    public static List<Lead> allLeads = new ArrayList();

    // crear list of opps
    public static List<Opportunity> allOps = new ArrayList<>();



    public Methods(){

    }

    public static void createLeadWithInput(){
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        System.out.println(Main.YELLOW + "||           NEW LEAD            ||" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        Scanner input = new Scanner(System.in);
        //String newInput = input.nextLine().toLowerCase();
        //if (newInput.equals("new lead")) {
            System.out.println(Main.YELLOW + "Introduce name" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
            String inputName = input.nextLine().toLowerCase();
            System.out.println(Main.YELLOW + "Introduce phone number" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
            String inputPhoneNumber = input.nextLine().toLowerCase();
            System.out.println(Main.YELLOW + "Introduce email" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
            String inputEmail = input.nextLine().toLowerCase();
            System.out.println(Main.YELLOW + "Introduce company name" + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
            String inputCompanyName = input.nextLine().toLowerCase();
            Lead lead = new Lead(inputName, inputPhoneNumber, inputEmail, inputCompanyName);
            addLeadToList(lead);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
            System.out.println(Main.YELLOW + "Lead created successfully: " + lead + Main.RESET);
        System.out.println(Main.YELLOW + "||-------------------------------||" + Main.RESET);
        //} else {
        //    System.out.println("Please try again with 'new lead'");
        //    createLeadWithInput();
        //}


    }


    //////// ESTOS 3 METODOS DE ABAJO SE PODRIAN AGRUPAR ENTRE ELLOS
    public static void convertLeadToOpportunity(List<Lead> leads) {

        if(leads.size() == 0){
            System.out.println(Main.RED + "ERROR! NO LEADS TO CONVERT, PLEASE CREATE ONE FIRST!" + Main.RESET);
        }else{
            System.out.println("Please input the lead ID you want to convert.");
            Scanner input = new Scanner(System.in);
            String newInput = input.nextLine().toLowerCase();
            Iterator var3 = leads.iterator();

            while(var3.hasNext()) {
                Lead lead = (Lead)var3.next();
                String num = String.valueOf(lead.getId());
                if (newInput.equals(num)) {

                    System.out.println("Lead found: " + lead.getName());
                    Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
                    System.out.println("New Contact created from this lead: " + contact);


                    createOpportunityAndAccount(contact, lead.getCompanyName());



                    //removeLead(lead);
                }
            }
        }

    }

    public static void createOpportunityAndAccount(Contact contact, String companyName) {




        System.out.println("Choose a Product: ");
        int menuCounter = 1;
        for (Products p : Products.values()){
            menuCounter++;
            System.out.println(menuCounter+") " + p);
        }
        Scanner inputProduct = new Scanner(System.in);
        Products product = Products.valueOf(inputProduct.next().toUpperCase());
        System.out.println("Done, you selected the product: " + product);


        System.out.println("Introduce quantity");
        Scanner inputQuantity = new Scanner(System.in);
        int quantity = inputQuantity.nextInt();
        System.out.println("Done, the quantity is: " + quantity);

        Opportunity opportunity = new Opportunity(product, quantity, contact, Status.OPEN);

        // Añadimos la opportunity a la lista de opps
        allOps.add(opportunity);
        System.out.println("New Opportunity created from this lead: " + opportunity);

        createAccount(companyName, contact, opportunity);



    }

    public static void createAccount(String companyName, Contact contact, Opportunity opportunity) {

        System.out.println("Choose an industry: ");
        for(Industry i : Industry.values()){
            System.out.println(i);
        }
        Scanner newIndustry = new Scanner(System.in);
        Industry industry = Industry.valueOf(newIndustry.next().toUpperCase());

        System.out.println("Introduce the number of employees");
        Scanner newEmployeeCount = new Scanner(System.in);
        String count = newEmployeeCount.nextLine();
        int employeeCount = Integer.parseInt(count);

        System.out.println("Introduce the city");
        Scanner newCity = new Scanner(System.in);
        String city = newCity.nextLine().toLowerCase();

        System.out.println("Introduce the country");
        Scanner newCountry = new Scanner(System.in);
        String country = newCountry.nextLine().toLowerCase();

        Account account = new Account(companyName, industry, employeeCount, city, country, contact, opportunity);
        System.out.println("New account ACCOUNT from this lead: " + account);



    }

/////////////////////////////////////////////////////////////////////////////////////////

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


    public static void showAllLeads() {
        if(allLeads.size() == 0) {
            System.out.println(Main.RED + "ERROR! NO LEADS TO DISPLAY, PLEASE CREATE ONE FIRST!" + Main.RESET);
        }else{
            Iterator var2 = allLeads.iterator();

            while(var2.hasNext()) {
                Lead lead = (Lead)var2.next();
                PrintStream var10000 = System.out;
                int var10001 = lead.getId();
                var10000.println(Main.PURPLE + "Lead id: " + var10001 + "\n Lead name: " + lead.getName() + "\n =======" + Main.RESET);
            }
        }
    }

    /*
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


     */

    // Metodo que printa todas las opportunities
    public static void listOfOpportunities() {
        if(allOps.size() == 0){
            System.out.println(Main.RED + "ERROR! NO OPPORTUNITIES TO DISPLAY, CONVERT ONE LEAD FIRST!" + Main.RESET);
        }else{
            for(Opportunity a : allOps){
                System.out.println(Main.PURPLE + allOps.get(allOps.indexOf(a) ) + Main.RESET);
            }
        }

    }



    public static List<Lead> getAllLeads() {
        return allLeads;
    }



}
