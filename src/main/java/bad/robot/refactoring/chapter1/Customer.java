package bad.robot.refactoring.chapter1;

public class Customer {

    private String name;
    private Rentals rentals = new Rentals();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addRental(Rental rental) {
        rentals.addRental(rental);
    }

    public String statement() {
        String result = "Rental record for " + getName() + "\n";
        result += rentals.getSummary();
        result += "Amount owed is " + String.valueOf(getTotalAmount()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    private double getTotalAmount() {
        return rentals.getTotalAmount();
    }

    private int getTotalFrequentRenterPoints() {
        return rentals.getTotalFrequentRenterPoints();
    }

}
