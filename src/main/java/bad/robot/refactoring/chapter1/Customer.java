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
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement() {
        String result = "<h1>Rental record for <b>" + getName() + "</b></h1>\n";
        for (Rental rental : rentals)
            result += "<p>" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getCharge()) + "</p>\n";
        result += "<p>Amount owed is <b>" + String.valueOf(getTotalCharge()) + "</b></p>\n";
        result += "<p>You earned <b>" + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points</b></p>";
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int points = 0;
        for (Rental rental : rentals)
            points += rental.getFrequentRenterPoints();
        return points;
    }

    private double getTotalCharge() {
        double charge = 0;
        for (Rental rental : rentals)
            charge += rental.getCharge();
        return charge;
    }

}
