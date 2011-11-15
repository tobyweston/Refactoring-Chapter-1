package bad.robot.refactoring.chapter1;

class ChildrensPrice extends Price {

    @Override
    double getCharge(int daysRented) {
        double amount = 1.5;
        if (daysRented > 3)
            amount += (daysRented - 3) * 1.5;
        return amount;
    }
}
