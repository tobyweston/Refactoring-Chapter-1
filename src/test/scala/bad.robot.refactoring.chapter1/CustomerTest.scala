package bad.robot.refactoring.chapter1

import org.junit.Test
import org.hamcrest.Matchers.is
import org.junit.Assert.assertThat
import CustomerTest._

object CustomerTest {
  val THE_HULK: Movie = new Movie("The Hulk", Movie.CHILDREN)
  val IRON_MAN: Movie = new Movie("Iron Man 4", Movie.NEW_RELEASE)
  val SPIDER_MAN: Movie = new Movie("Spiderman", Movie.REGULAR)
}

class CustomerTest {

  @Test
  def basicChildrenRental {
    val customer = Customer("fred").addRental(new Rental(THE_HULK, 2))
    assertThat(customer.statement, is("Rental record for fred\n\tThe Hulk\t1.5\nAmount owed is 1.5\nYou earned 1 frequent renter points"))
  }

  @Test
  def shouldDiscountChildrensRentals {
    val customer = new Customer("fred").addRental(new Rental(THE_HULK, 4))
    assertThat(customer.statement, is("Rental record for fred\n\tThe Hulk\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"))
  }

  @Test
  def basicNewReleaseRental {
    val customer = new Customer("fred").addRental(new Rental(IRON_MAN, 1))
    assertThat(customer.statement, is("Rental record for fred\n\tIron Man 4\t3.0\nAmount owed is 3.0\nYou earned 1 frequent renter points"))
  }

  @Test
  def shouldNotDiscountNewReleaseRentalsButBonusFrequentRenterPoints {
    val customer = new Customer("fred").addRental(new Rental(IRON_MAN, 4))
    assertThat(customer.statement, is("Rental record for fred\n\tIron Man 4\t12.0\nAmount owed is 12.0\nYou earned 2 frequent renter points"))
  }

  @Test
  def basicRegularRental {
    val customer = new Customer("fred").addRental(new Rental(SPIDER_MAN, 2))
    assertThat(customer.statement, is("Rental record for fred\n\tSpiderman\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points"))
  }

  @Test
  def shouldDiscountRegularRental {
    val customer = new Customer("fred").addRental(new Rental(SPIDER_MAN, 4))
    assertThat(customer.statement, is("Rental record for fred\n\tSpiderman\t5.0\nAmount owed is 5.0\nYou earned 1 frequent renter points"))
  }

  @Test
  def shouldSumVariousRentals {
    val customer = new Customer("fred")
      .addRental(new Rental(THE_HULK, 2))
      .addRental(new Rental(SPIDER_MAN, 1))
      .addRental(new Rental(IRON_MAN, 3))
    assertThat(customer.statement, is("Rental record for fred\n\tThe Hulk\t1.5\n\tSpiderman\t2.0\n\tIron Man 4\t9.0\nAmount owed is 12.5\nYou earned 4 frequent renter points"))
  }

}

