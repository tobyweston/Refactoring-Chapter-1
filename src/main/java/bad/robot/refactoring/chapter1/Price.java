package bad.robot.refactoring.chapter1;

public abstract class Price {

    abstract int getPriceCode();

    double getCharge(int daysRented) {
        double amount = 0;
        switch (getPriceCode()) {
            // none left!
        }
        return amount;
    }
}
