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

    double getCharge() {
        return movie.getChargeFor(daysRented);
    }

    int getFrequentRentalPoints() {
        return movie.getFrequentRentalPoints(daysRented);
    }
}
