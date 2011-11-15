package bad.robot.refactoring.chapter1;

public class Rental {

    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public double getCharge() {
        return movie.getCharge(daysRented);
    }

    public int getFrequentRenterPoints() {
        if (getMovie().getPriceCode() == Movie.NEW_RELEASE && getDaysRented() > 1)
            return 2;
        return 1;
    }
}
