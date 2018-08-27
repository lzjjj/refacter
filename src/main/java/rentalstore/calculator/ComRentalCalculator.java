package rentalstore.calculator;

public class ComRentalCalculator implements RentalCalculator {

    protected int dayRented;
    protected int dayStartToRent;
    protected double startingPrice;
    protected double perDayPrice;

    public ComRentalCalculator(int dayRented, int dayStartToRent, double startingPrice, double perDayPrice) {
        this.dayRented = dayRented;
        this.dayStartToRent = dayStartToRent;
        this.startingPrice = startingPrice;
        this.perDayPrice = perDayPrice;
    }

    public int getDayRented() {
        return dayRented;
    }

    public void setDayRented(int dayRented) {
        this.dayRented = dayRented;
    }

    public int getDayStartToRent() {
        return dayStartToRent;
    }

    public void setDayStartToRent(int dayStartToRent) {
        this.dayStartToRent = dayStartToRent;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getPerDayPrice() {
        return perDayPrice;
    }

    public void setPerDayPrice(double perDayPrice) {
        this.perDayPrice = perDayPrice;
    }

    public double calcAmount() {
        double amount = 0;
        amount += startingPrice;
        if(dayRented > dayStartToRent) {
            amount += (dayRented - dayStartToRent) * perDayPrice;
        }
        return amount;

    }

    public int calcFrequentRenterPoint() {
        int frequentRenterPoint = 1;
        return frequentRenterPoint;
    }
}
