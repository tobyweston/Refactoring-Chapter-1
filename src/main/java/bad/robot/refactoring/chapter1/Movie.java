package bad.robot.refactoring.chapter1;

import static bad.robot.refactoring.chapter1.Movie.Classification.NEW_RELEASE;

public class Movie {

    public enum Classification {
        CHILDREN {
            @Override
            public double getCharge(int daysRented) {
                double amount = 1.5;
                if (daysRented > 3)
                    amount += (daysRented - 3) * 1.5;
                return amount;
            }
        },
        REGULAR {
            @Override
            public double getCharge(int daysRented) {
                double amount = 2;
                if (daysRented > 2)
                    amount += (daysRented - 2) * 1.5;
                return amount;
            }
        },
        NEW_RELEASE {
            @Override
            public double getCharge(int daysRented) {
                return daysRented * 3;
            }
        };

        public abstract double getCharge(int daysRented);
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

    double getChargeFor(int daysRented) {
        return classification.getCharge(daysRented);
    }

    public int getFrequentRentalPoints(int daysRented) {
        if (classification == NEW_RELEASE && daysRented > 1)
            return 2;
        return 1;
    }
}
