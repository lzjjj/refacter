package rentalstore.statement;

import rentalstore.Customer;

public abstract class Statement {
    protected double totalAmount;
    protected int frequentRenterPoints;

    public String statement(Customer customer) {
        String result = getHeader(customer);
        result = getBody(customer, result);
        result = getFooter(result);
        return result;
    }

    protected abstract String getFooter(String result);

    protected abstract String getBody(Customer customer, String result);

    protected abstract String getHeader(Customer customer);
}
