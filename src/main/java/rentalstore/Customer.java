package rentalstore;

import rentalstore.statement.Statement;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    private Statement statement;

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, Statement statement) {
        this.name = name;
        this.statement = statement;
    }

    public void addRental(Rental arg) {
        rentals.addElement(arg);
    }

    public String getName() {
        return name;
    }

    public Vector getRentals() {
        return rentals;
    }

    public String statement() {
//        String result = "RentalOfChildren Record for " + getName() + "\n";
//        double totalAmount = 0;
//        int frequentRenterPoints = 0;
//        Enumeration rentals = this.rentals.elements();
//
//        while (rentals.hasMoreElements()) {
//            double thisAmount = 0;
//            Rental each = (Rental) rentals.nextElement();
//
//            thisAmount = each.getAmount();
//            //show figures for this rental
//            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
//
//            frequentRenterPoints += each.getFrequentRenterPoint();
//            totalAmount += thisAmount;
//        }
//
//        //add footer lines
//        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
//        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
//        return result;
        return statement.statement(this);
    }

}
