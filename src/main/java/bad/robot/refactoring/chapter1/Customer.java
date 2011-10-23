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
        return "Rental record for " + getName() + "\n" + rentals.getStatement();
    }

}
