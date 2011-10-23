package bad.robot.refactoring.chapter1;

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
        return classification.getFrequentRentalPoints(daysRented);
    }
}
