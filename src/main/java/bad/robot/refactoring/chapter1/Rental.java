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
        double amount = 0;
        switch (getMovie().getClassification()) {
            case REGULAR:
                amount += 2;
                if (getDaysRented() > 2)
                    amount += (getDaysRented() - 2) * 1.5;
                break;
            case NEW_RELEASE:
                amount += getDaysRented() * 3;
                break;
            case CHILDREN:
                amount += 1.5;
                if (getDaysRented() > 3)
                    amount += (getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }

    int getFrequentRentalPoints() {
        if (getMovie().getClassification() == NEW_RELEASE && getDaysRented() > 1)
            return 2;
        return 1;
    }
}
