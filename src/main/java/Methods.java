import classes.Account;
import classes.Contact;
import classes.Lead;
import classes.Opportunity;
import enums.Industry;
import enums.Products;
import enums.Status;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Methods {

    public static List<Lead> allLeads = new ArrayList();

    public static List<Opportunity> allOps = new ArrayList<>();

    public Methods(){}

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
    public static void convertLeadToOpportunity() {

        if(allLeads.size() == 0){
            System.out.println(Main.ANSI_RED_BACKGROUND + "ERROR! NO LEADS TO CONVERT, PLEASE CREATE ONE FIRST!" + Main.ANSI_RESET_BACK);
        }else{
            try{
                System.out.println("Please input the lead ID you want to convert.");
                Scanner input = new Scanner(System.in);
                String newInput = input.nextLine().toLowerCase();

                Lead lead = allLeads.get(Integer.valueOf(newInput));
                System.out.println("Lead found: " + lead.getName());
                Contact contact = new Contact(lead.getName(), lead.getPhoneNumber(), lead.getEmail(), lead.getCompanyName());
                System.out.println("New Contact created from this lead: " + contact);

                createOpportunityAndAccount(contact, lead.getCompanyName());

                removeLead(lead);
            }catch (Exception e){
                System.out.println(Main.RED + "ERROR! The index introduced does NOT exist!" + Main.RESET);
                convertLeadToOpportunity();
            }
        }
    }

    public static void createOpportunityAndAccount(Contact contact, String companyName) {


        System.out.println("Choose a Product: ");
        List<String> enumsList = new ArrayList<>();
        for (Products p : Products.values()){
            System.out.println(p.ordinal() +" ) " + p);
            enumsList.add(p.name());
        }

        Scanner pro = new Scanner(System.in);
        int inputProduct = pro.nextInt();
        try{
            Products product = Products.valueOf(enumsList.get(inputProduct));
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

        }catch(Exception e){
            System.out.println(Main.ANSI_RED_BACKGROUND + "ERROR! INCORRECT INPUT!! --Back to main menu" + Main.ANSI_RESET_BACK);
            convertLeadToOpportunity();

        }

    }

    public static void createAccount(String companyName, Contact contact, Opportunity opportunity) {

        System.out.println("Choose an industry: ");
        List<String> enumsList = new ArrayList<>();
        for(Industry i : Industry.values()){
            System.out.println(i.ordinal() + " ) " + i);
            enumsList.add(i.name());
        }
        Scanner ind = new Scanner(System.in);
        int industryInput = ind.nextInt();
        try{
            Industry industry = Industry.valueOf((enumsList.get(industryInput)));
            System.out.println("Done, you selected the industry: " + industry);
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

        }catch(Exception e){
            System.out.println(Main.ANSI_RED_BACKGROUND + "ERROR! INCORRECT INPUT!! --Back to main menu" + Main.ANSI_RESET_BACK);
            convertLeadToOpportunity();

        }





    }

/////////////////////////////////////////////////////////////////////////////////////////

    public static void closeOpportunity(){
        if(allOps.size() == 0){
            System.out.println(Main.ANSI_RED_BACKGROUND + "ERROR! There are no opportunities to update! " + Main.ANSI_RESET_BACK);
        }else{
            try{
                System.out.println("Please input the id of the opportunity you want to update.");
                Scanner opid = new Scanner(System.in);
                String closOpInput = opid.nextLine().toLowerCase();

                System.out.println("The current status is:  " + allOps.get(Integer.valueOf(closOpInput)).getStatus());

                System.out.println("Choose a new status:");
                System.out.println(Main.RED + "1) LOST CLOSED" + Main.RESET);
                System.out.println(Main.GREEN + "2) WON CLOSED" + Main.RESET);

                Scanner status = new Scanner(System.in);
                String statusInput = status.nextLine().toLowerCase();


                for(Opportunity opp : allOps){
                    String num = String.valueOf(opp.getOpId());
                    if(Integer.valueOf(statusInput) == 1){
                        opp.setStatus(Status.CLOSE_LOST);
                        System.out.println("Opportunity " + opp.getOpId() + Main.RED + " is " + opp.getStatus() + Main.RESET);
                    }else if(Integer.valueOf(statusInput) == 2){
                        opp.setStatus(Status.CLOSE_WON);
                        System.out.println("Opportunity " + opp.getOpId() + Main.GREEN +  " is " + opp.getStatus() + Main.RESET);
                    }
                    else{
                        System.out.println(Main.RED + "ERROR! INCORRECT INPUT!");
                        closeOpportunity();
                    }
                }
            }catch(Exception e){
                System.out.println(Main.RED + "ERROR! The opportunity does NOT exist! " + Main.RESET);
                closeOpportunity();
            }
        }
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


    public static void showAllLeads() {
        if(allLeads.size() == 0) {
            System.out.println(Main.ANSI_RED_BACKGROUND + "ERROR! NO LEADS TO DISPLAY, PLEASE CREATE ONE FIRST!" + Main.ANSI_RESET_BACK);
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




}
