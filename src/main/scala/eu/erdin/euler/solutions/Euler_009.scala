package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

/**
  * Created by robert on 09/10/16.
  */
object Euler_009 extends EulerSolution{
  override def answer(): Any = {
    val answerTuple = (for {
      a <- 1 to 1000
      b <- 1 to 1000
      c <- 1 to 1000
      if a < b && b < c
      if a*a + b*b == c*c
      if a + b + c == 1000
    } yield (a, b, c)).head

    answerTuple._1 * answerTuple._2 * answerTuple._3
  }
}
