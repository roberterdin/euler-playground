package eu.erdin.euler

/**
  * Created by robert on 08/10/16.
  */
object Euler_004 extends EulerSolution {

  def isPalindromic(x: Int): Boolean = {
    x.toString.map(_.asDigit) == x.toString.map(_.asDigit).reverse
  }

  override def answer(): Any = {

    // inefficient because whole list of all palindromes needs to be generated
    ((for {
      i <- 999 to 1 by -1
      j <- 999 to 1 by -1
      if isPalindromic (i * j)
    } yield (i, j)) foldLeft 0) { (acc: Int, el: (Int, Int)) =>
      acc max el._1 * el._2
    }

    // investigate: http://stackoverflow.com/questions/21286890/find-the-largest-palindrome-made-from-the-product-of-two-3-digit-numbers-javas

  }
}
