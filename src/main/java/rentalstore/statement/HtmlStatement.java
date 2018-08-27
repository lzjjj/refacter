package rentalstore.statement;

import rentalstore.Customer;
import rentalstore.Rental;

import java.util.Enumeration;

public class HtmlStatement extends Statement{

    protected String getFooter(String result) {
        result += "<P>You owe<EM>" + String.valueOf(totalAmount) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf(frequentRenterPoints) + "</EM> frequent renter points<P>";
        return result;
    }

    protected String getBody(Customer customer, String result) {
        Enumeration rentals = customer.getRentals().elements();

        while (rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) rentals.nextElement();

            thisAmount = each.getAmount();
            //show figures for this rental
            result += each.getMovie().getTitle() + ": " + String.valueOf(thisAmount) + "<BR>\n";

            frequentRenterPoints += each.getFrequentRenterPoint();
            totalAmount += thisAmount;
        }
        return result;
    }

    protected String getHeader(Customer customer) {
        return "<H1>Rentals for <EM>" + customer.getName() + "</EM></H1><P>\n";
    }

}
