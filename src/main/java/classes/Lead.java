//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package classes;

import enums.Status;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Lead {
    private final int id;
    private static int counter = 1;
    private String name;
    private String phoneNumber;
    private String email;
    private String companyName;


    public Lead(String name, String phoneNumber, String email, String companyName) {
        this.id = counter++;
        this.setPhoneNumber(phoneNumber);
        this.setName(name);
        this.setEmail(email);
        this.setCompanyName(companyName);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompanyName() {
        return this.companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }


    public String toString() {
        return "Lead{id=" + this.id + ", name='" + this.name + "', phoneNumber='" + this.phoneNumber + "', email='" + this.email + "', companyName='" + this.companyName + "'}";
    }


}
