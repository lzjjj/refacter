package rentalstore.calculator;

public class NewReleaseRentalCalculator implements RentalCalculator {
    private int dayRented;
    private double perDayPrice;

    public NewReleaseRentalCalculator(int dayRented, double perDayPrice) {
        this.dayRented = dayRented;
        this.perDayPrice = perDayPrice;
    }

    public double calcAmount() {
        double amount = 0.0;
        amount += dayRented * perDayPrice;
        return amount;
    }

    public int calcFrequentRenterPoint() {
        int frequentRenterPoint = 1;
        if (dayRented > 1) {
            frequentRenterPoint++;
        }
        return frequentRenterPoint;
    }
}
