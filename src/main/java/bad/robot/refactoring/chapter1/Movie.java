package bad.robot.refactoring.chapter1;

import static bad.robot.refactoring.chapter1.Movie.Classification.NEW_RELEASE;

public class Movie {

    public enum Classification {
        CHILDREN,
        REGULAR,
        NEW_RELEASE;
    }

    private String title;
    private Classification classification;

    public Movie(String title, Classification classification) {
        this.title = title;
        this.classification = classification;
    }

    public String getTitle() {
        return title;
    }

    public Classification getClassification() {
        return classification;
    }

    double getChargeFor(int daysRented) {
        double amount = 0;
        switch (classification) {
            case REGULAR:
                amount += 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                amount += daysRented * 3;
                break;
            case CHILDREN:
                amount += 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                break;
        }
        return amount;
    }

    public int getFrequentRentalPoints(int daysRented) {
        if (classification == NEW_RELEASE && daysRented > 1)
            return 2;
        return 1;
    }
}
