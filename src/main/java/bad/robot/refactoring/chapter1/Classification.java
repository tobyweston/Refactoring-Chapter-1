package bad.robot.refactoring.chapter1;

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
