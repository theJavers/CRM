package classes;

import enums.Industry;
import enums.Products;

import java.util.ArrayList;
import java.util.Scanner;

public class Account {

    private final int ID;
    private static int counter = 1;
    private String companyName;
    private Industry industry;
    private int employeeCount;
    private String city;
    private String country;
    private ArrayList<Contact> contactList = new ArrayList<>();
    private ArrayList<Opportunity> opportunityList = new ArrayList<>();

    public Account(String companyName, Contact contact, Opportunity opportunity) {
        setCompanyName(companyName);
        setIndustry();
        setEmployeeCount();
        setCity();
        setCountry();
        setContactList(contact);
        setOpportunityList(opportunity);
        this.ID = counter++;
    }



    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Industry getIndustry() {
        return industry;
    }

    public void setIndustry() {
        System.out.println("Choose an industry: ");
        for(Industry i : Industry.values()){
            System.out.println(i);
        }
        Scanner newIndustry = new Scanner(System.in);
        this.industry = Industry.valueOf(newIndustry.next().toUpperCase());
    }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount() {
        System.out.println("Introduce the number of employees");
        Scanner newEmployeeCount = new Scanner(System.in);
        String count = newEmployeeCount.nextLine();
        this.employeeCount = Integer.parseInt(count);
    }

    public String getCity() {
        return city;
    }

    public void setCity() {
        System.out.println("Introduce the city");
        Scanner newCity = new Scanner(System.in);
        this.city = newCity.nextLine().toLowerCase();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry() {
        System.out.println("Introduce the country");
        Scanner newCountry = new Scanner(System.in);
        this.country = newCountry.nextLine().toLowerCase();
    }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(Contact contact) {
        contactList.add(contact);
    }

    public ArrayList<Opportunity> getOpportunityList() {
        return opportunityList;
    }

    public void setOpportunityList(Opportunity opportunity) {
        opportunityList.add(opportunity);
    }

    @Override
    public String toString() {
        return "Account{" +
                "ID=" + ID +
                ", companyName='" + companyName + '\'' +
                ", industry=" + industry +
                ", employeeCount=" + employeeCount +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", contactList=" + contactList +
                ", opportunityList=" + opportunityList +
                '}';
    }
}
