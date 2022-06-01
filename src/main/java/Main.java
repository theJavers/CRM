import classes.Lead;
import classes.Opportunity;

import java.util.Arrays;

import static classes.Lead.listOportunitiesId;


public class Main {

    public static void main(String[] args) {
        System.out.println("||---------------------------------||");
        System.out.println("||          Welcome to             ||");
        System.out.println("||          JAVERS CRM             ||");
        System.out.println("||---------------------------------||");

        Lead.createLeadWithInput();

        Lead.convertLeadToOpportunity(Lead.getAllLeads());

     //   Lead.listOfOpportunities();

        Lead.listOportunitiesId();

        Lead.showAllLeads();

        Lead.closeOpportunity();
    }
}
