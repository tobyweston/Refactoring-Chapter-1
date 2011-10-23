package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Rentals {

    private final List<Rental> rentals = new ArrayList<Rental>();

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public double getTotalCharge() {
        double amount = 0;
        for (Rental rental : rentals)
            amount += rental.getCharge();
        return amount;
    }

    public int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : rentals)
            total += rental.getFrequentRentalPoints();
        return total;
    }

    public String getStatement() {
        String result = getSummary();
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private String getSummary() {
        String summary = "";
        for (Rental rental : rentals)
            summary += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        return summary;
    }
}
