package rentalstore;

import org.junit.Before;
import org.junit.Test;
import rentalstore.calculator.ComRentalCalculator;
import rentalstore.calculator.NewReleaseRentalCalculator;
import rentalstore.statement.HtmlStatement;
import rentalstore.statement.TextStatement;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

    private Customer customer;
    private Customer customer2;
    private Movie regularMovie;
    private Movie newReleaseMovie;
    private Movie childrenMovie;

    Rental oneRentalOfRegular;
    Rental threeRentalOfRegular;

    Rental oneRentalOfNewRelease;
    Rental twoRentalOfNewRelease;

    Rental oneRentalOfChildren;
    Rental fourRentalOfChildren;

    @Before
    public void before() {
        customer = new Customer("Jerry", new TextStatement());
        customer2 = new Customer("louis", new HtmlStatement());
        regularMovie = new Movie("Titanic");
        newReleaseMovie = new Movie("Titanic");
        childrenMovie  = new Movie("Titanic");

        oneRentalOfRegular = new Rental(regularMovie, new ComRentalCalculator(1, 2, 2, 1.5));
        threeRentalOfRegular = new Rental(regularMovie, new ComRentalCalculator(3, 2, 2, 1.5));

        oneRentalOfNewRelease = new Rental(newReleaseMovie, new NewReleaseRentalCalculator(1,3));
        twoRentalOfNewRelease = new Rental(newReleaseMovie, new NewReleaseRentalCalculator(2, 3));

        oneRentalOfChildren = new Rental(newReleaseMovie, new ComRentalCalculator(1, 3, 1.5, 1.5));
        fourRentalOfChildren = new Rental(newReleaseMovie, new ComRentalCalculator(4, 3, 1.5, 1.5));
    }

    @Test
    public void should_return_correct_statement_given_customer_has_no_rental() {
        String statement = customer.statement();
        assertEquals("RentalOfChildren Record for Jerry\n"
                + "Amount owed is 0.0\n"
                + "You earned 0 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_1_day() {
        customer.addRental(oneRentalOfRegular);

        String statement = customer.statement();

        assertEquals("RentalOfChildren Record for Jerry\n"
                + "\t"
                + regularMovie.getTitle()
                + "\t2.0\n"
                + "Amount owed is 2.0\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_regular_movie_for_3_day() {
        customer.addRental(threeRentalOfRegular);

        String statement = customer.statement();

        assertEquals("RentalOfChildren Record for Jerry\n"
                + "\t"
                + regularMovie.getTitle()
                + "\t3.5\n"
                + "Amount owed is 3.5\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_1_day() {
        customer.addRental(oneRentalOfNewRelease);

        String statement = customer.statement();

        assertEquals("RentalOfChildren Record for Jerry\n"
                + "\t"
                + newReleaseMovie.getTitle()
                + "\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_new_release_movie_for_2_day() {
        customer.addRental(twoRentalOfNewRelease);

        String statement = customer.statement();

        assertEquals("RentalOfChildren Record for Jerry\n"
                + "\t"
                + newReleaseMovie.getTitle()
                + "\t6.0\n"
                + "Amount owed is 6.0\n"
                + "You earned 2 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_1_day() {
        customer.addRental(oneRentalOfChildren);

        String statement = customer.statement();

        assertEquals("RentalOfChildren Record for Jerry\n"
                + "\t" + childrenMovie.getTitle()
                + "\t1.5\n"
                + "Amount owed is 1.5\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        customer.addRental(fourRentalOfChildren);

        String statement = customer.statement();

        assertEquals("RentalOfChildren Record for Jerry\n"
                + "\t"
                + childrenMovie.getTitle()
                + "\t3.0\n"
                + "Amount owed is 3.0\n"
                + "You earned 1 frequent renter points", statement);
    }

    @Test
    public void should_return_correct_html_statement_given_customer_has_rent_one_child_movie_for_4_day() {
        customer2.addRental(fourRentalOfChildren);

        String statement = customer2.statement();

        System.out.println(statement);

        assertEquals("<H1>Rentals for <EM>louis</EM></H1><P>\n" +
                "Titanic: 3.0<BR>\n" +
                "<P>You owe<EM>3.0</EM><P>\n" +
                "On this rental you earned <EM>1</EM> frequent renter points<P>", statement);
    }

}
