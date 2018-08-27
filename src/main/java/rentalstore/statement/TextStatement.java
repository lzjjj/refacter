package rentalstore.statement;

import rentalstore.Customer;
import rentalstore.Rental;

import java.util.Enumeration;

public class TextStatement extends Statement{

    protected String getFooter(String result) {
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }

    protected String getBody(Customer customer, String result) {
        Enumeration rentals = customer.getRentals().elements();

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            thisAmount = each.getAmount();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";

            frequentRenterPoints += each.getFrequentRenterPoint();
            totalAmount += thisAmount;
        }
        return result;
    }

    protected String getHeader(Customer customer) {
        return "RentalOfChildren Record for " + customer.getName() + "\n";
    }
}
