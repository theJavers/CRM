import classes.Lead;
import classes.Opportunity;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;


public class Main {

    //// RESET AND COLORS
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001b[32;1m";
    public static final String PURPLE = "\u001B[35m";
    public static final String YELLOW = "\u001B[33m";

    // RED BACKGROUND
    public static final String ANSI_RESET_BACK = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";



    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.runMenuAndHeader();

    }

    public static void performAction(int choice) throws IOException {
        switch (choice){
            case 0:
                System.out.println("See you soon!");
                break;
            case 1:
                Methods.createLeadWithInput();
                Main.runMenuAndHeader();
                break;
            case 2:
                Methods.showAllLeads();
                Main.runMenuAndHeader();
                break;
            case 3:
                Methods.convertLeadToOpportunity();
                Main.runMenuAndHeader();
                break;
            case 4:
                Methods.listOfOpportunities();
                Main.runMenuAndHeader();
            case 5:
                Methods.closeOpportunity();
                Main.runMenuAndHeader();
            default:
                System.out.println(ANSI_RED_BACKGROUND + "An error has occoured." + ANSI_RESET_BACK);

        }

    }


    public static void runMenuAndHeader() throws IOException {
        printHeader();
        printMenu();
        int choice = getInput();
        performAction(choice);

    }

    private static void printHeader(){
        System.out.println("||---------------------------------||");
        System.out.println("||          Welcome to             ||");
        System.out.println("||          JAVERS CRM             ||");
        System.out.println("||---------------------------------||");

    }

    private static void printMenu(){
        System.out.println(PURPLE + "Please, choose one of the following options:" + RESET);
        System.out.println("1) New lead.");
        System.out.println("2) Show all leads. There are currently ---------->    " + YELLOW + Methods.allLeads.size() +  "  leads." + RESET);
        System.out.println("3) Convert lead to opportunity + /lead id/.");
        System.out.println("4) Show all opportunities. There are currently -->    " + RED + Methods.allOps.size() + "  opportunities." + RESET);
        System.out.println("5) Update an opportunity.");
        System.out.println("0) Close CRM.");
    }


    private static int getInput(){
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        while(choice < 0 || choice > 5){
            try{
                choice = Integer.parseInt(kb.nextLine());
            }
            catch (NumberFormatException e){
                System.out.println("Invalid selection, please try again -_- \n");
                printMenu();

            }
        }
        return choice;
    }

}
