package bad.robot.refactoring.chapter1;

class ChildrensPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.CHILDREN;
    }
}
