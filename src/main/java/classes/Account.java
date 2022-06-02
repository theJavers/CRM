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
    private ArrayList<Opportunity> opportunityListInConcatcts = new ArrayList<>();

    public Account(String companyName, Industry industry, int employeeCount, String city, String country, Contact contact, Opportunity opportunity) {
        setCompanyName(companyName);
        setIndustry(industry);
        setEmployeeCount(employeeCount);
        setCity(city);
        setCountry(country);
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

    public void setIndustry(Industry industry) { this.industry = industry; }

    public int getEmployeeCount() {
        return employeeCount;
    }

    public void setEmployeeCount(int employeeCount) { this.employeeCount = employeeCount; }

    public String getCity() {
        return city;
    }

    public void setCity(String city) { this.city = city; }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) { this.country = country; }

    public ArrayList<Contact> getContactList() {
        return contactList;
    }

    public void setContactList(Contact contact) {
        contactList.add(contact);
    }

    public ArrayList<Opportunity> getOpportunityList() {
        return opportunityListInConcatcts;
    }

    public void setOpportunityList(Opportunity opportunity) {
        opportunityListInConcatcts.add(opportunity);
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
                ", opportunityList=" + opportunityListInConcatcts +
                '}';
    }
}
