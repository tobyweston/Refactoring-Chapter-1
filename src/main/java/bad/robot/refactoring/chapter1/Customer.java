package bad.robot.refactoring.chapter1;

import java.util.ArrayList;
import java.util.List;

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
        String result = "Rental record for " + getName() + "\n";
        for (Rental rental : rentals)
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "\n";
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        double amount = 0;
        for (Rental rental : rentals)
            amount += rental.getCharge();
        return amount;
    }

    private int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : rentals)
            total += rental.getFrequentRentalPoints();
        return total;
    }

}
