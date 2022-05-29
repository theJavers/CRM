import classes.Lead;


public class Main {

    public static void main(String[] args) {
        Lead lead = new Lead("fjsfs", "fjs", "fdjss", "ggdj");
        Lead lead2 = new Lead("fjsfs", "fjs", "fdjss", "ggdj");
        Lead lead3 = new Lead("fjsfs", "fjs", "fdjss", "ggdj");

        Lead.addLeadToList(lead);
        Lead.addLeadToList(lead2);
        Lead.addLeadToList(lead3);
        Lead.convertLeadToOp(Lead.getAllLeads());
    }
}
