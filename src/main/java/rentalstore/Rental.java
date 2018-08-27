package rentalstore;

import rentalstore.calculator.RentalCalculator;

public class Rental {
    private Movie movie;
    private RentalCalculator calculator;

    public Rental(Movie movie, RentalCalculator calculator) {
        this.movie = movie;
        this.calculator = calculator;
    }

    public Movie getMovie() {
        return movie;
    }


    public double getAmount() {
        return calculator.calcAmount();
    }

    public int getFrequentRenterPoint() {
        return calculator.calcFrequentRenterPoint();
    }

}
