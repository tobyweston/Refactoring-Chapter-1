package bad.robot.refactoring.chapter1


case class Customer(name: String, rentals: Seq[Rental] = Seq()) {

  def addRental(rental: Rental): Customer = {
    Customer(name, rentals :+ rental)
  }

  def statement: String = {
    var totalAmount: Double = 0
    var frequentRenterPoints = 0
    var result = "Rental record for " + name + "\n"

    for (rental <- rentals) {
      var amount: Double = amountFor(rental)
      frequentRenterPoints += 1
      if (rental.movie.priceCode == Movie.NEW_RELEASE && rental.daysRented > 1)
        frequentRenterPoints += 1; frequentRenterPoints - 1
      result += "\t" + rental.movie.title + "\t" + String.valueOf(amount) + "\n"
      totalAmount += amount
    }
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n"
    result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points"
    return result
  }

  private def amountFor(rental: Rental): Double = {
    var amount: Double = 0
    rental.movie.priceCode match {
      case Movie.REGULAR =>
        amount += 2
        if (rental.daysRented > 2)
          amount += (rental.daysRented - 2) * 1.5
      case Movie.NEW_RELEASE =>
        amount += rental.daysRented * 3
      case Movie.CHILDREN =>
        amount += 1.5
        if (rental.daysRented > 3)
          amount += (rental.daysRented - 3) * 1.5
    }
    amount
  }

}

