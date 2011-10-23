package bad.robot.refactoring.chapter1;

import static bad.robot.refactoring.chapter1.Movie.Classification.NEW_RELEASE;

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

    double getCharge() {
        return movie.getChargeFor(daysRented);
    }

    int getFrequentRentalPoints() {
        if (getMovie().getClassification() == NEW_RELEASE && getDaysRented() > 1)
            return 2;
        return 1;
    }
}
