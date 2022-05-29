import classes.Lead;


public class Main {

    public static void main(String[] args) {

        Lead.createLeadWithInput();
        Lead.convertLeadToOpportunity(Lead.getAllLeads());
    }
}
