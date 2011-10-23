package bad.robot.refactoring.chapter1;

import static bad.robot.refactoring.chapter1.Classification.NEW_RELEASE;

public class Movie {

    private String title;
    private Classification classification;

    public Movie(String title, Classification classification) {
        this.title = title;
        this.classification = classification;
    }

    public String getTitle() {
        return title;
    }

    double getChargeFor(int daysRented) {
        return classification.getCharge(daysRented);
    }

    public int getFrequentRentalPoints(int daysRented) {
        if (classification == NEW_RELEASE && daysRented > 1)
            return 2;
        return 1;
    }
}
