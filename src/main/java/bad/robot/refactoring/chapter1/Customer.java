package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

import static bad.robot.refactoring.chapter1.Movie.Classification.NEW_RELEASE;

public class Customer {

    private String name;
    private List<Rental> rentals = new ArrayList<Rental>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;

        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals) {

            frequentRenterPoints += getFrequentRentalPoints(rental);

            // show figures for this rental
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";

            totalAmount += rental.getCharge();
        }

        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";

        return result;
    }

    private int getFrequentRentalPoints(Rental rental) {
        if (rental.getMovie().getClassification() == NEW_RELEASE && rental.getDaysRented() > 1)
            return 2;
        return 1;
    }

}
