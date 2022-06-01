package classes;

import enums.Products;
import enums.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static enums.Status.CLOSE;

public class Opportunity {
    private final int opId;
    private static int counter = 1;
    private Products product;
    private int quantity;
    private Contact decisionMaker;
    private Status status;


    public Opportunity(Contact decisionMaker, Status status) {

        this.opId = counter++;
        setProduct();
        setQuantity();
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }




    public int getOpId() {
        return opId;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct() {

        Scanner input = new Scanner(System.in);

            System.out.println("Choose a Product: ");
            for (Products p : Products.values()){
                System.out.println(p);
            }
            Products inputProduct = Products.valueOf(input.next().toUpperCase());
            this.product = inputProduct;
        System.out.println("Done, you selected the product: " + inputProduct);

        }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity() {

        Scanner input = new Scanner(System.in);

        System.out.println("Introduce quantity");
        int inputQuantity = input.nextInt();
        this.quantity = inputQuantity;
        System.out.println("Done, the quantity is: " + inputQuantity);
    }

    //***************************************************************************
     public void showOpportunity(){
        Scanner input = new Scanner(System.in);
        String opportunityNum = input.nextLine().toLowerCase();
        if(opportunityNum.equals("lookup opportunity" + opportunityNum)) {
            getOpId();
            //System.out.println(opportunityList(getOpId()));

        }else{
            System.out.println("Please add a valid opportunity number");
        }

    }


    public void closeOpportunity(){
        //Sara types “close-lost 24” and the CRM changes the status of opportunity 24 to “CLOSED-LOST”
        Scanner input = new Scanner(System.in);
        String closOpInput = input.nextLine().toLowerCase();
        if(closOpInput.equals("close-lost 24")){
            setStatus(CLOSE);
            System.out.println("Opportunity 24 is CLOSED-LOST");
        }else{
            System.out.println("Error");
        }
    }

    //*********************************************************************************

    public Contact getDecisionMaker() {
        return decisionMaker;
    }

    public void setDecisionMaker(Contact decisionMaker) {
        this.decisionMaker = decisionMaker;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Opportunity{" +
                "opId=" + opId +
                ", product=" + product +
                ", quantity=" + quantity +
                ", decisionMaker=" + decisionMaker +
                ", status=" + status +
                '}';
    }
}
