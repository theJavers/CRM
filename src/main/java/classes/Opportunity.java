package classes;

import enums.Products;
import enums.Status;

import java.util.List;
import java.util.Scanner;

public class Opportunity {
    private final int opId;
    private static int counter = 1;
    private Order order;
    private Contact decisionMaker;
    private Status status;

    public Opportunity(Order order, Contact decisionMaker, Status status) {
        this.opId = counter++;
        setOrder(order);
        setDecisionMaker(decisionMaker);
        setStatus(status);
    }

    public int getOpId() {
        return opId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

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


}
