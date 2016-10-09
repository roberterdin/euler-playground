package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

/**
  * Created by robert on 09/10/16.
  */
object Euler_006 extends EulerSolution{
  override def answer(): Any = {
    val n = 100

    // sum of squares
//    val sumOfSquares = (min to n).foldLeft(0)((acc, el) => {
//      acc + el * el
//    })
    val sumOfSquares = (n * (n+1) * (2 * n + 1))/6

    // square of the sum
    val squareOfSum = scala.math.pow((1.toDouble + n.toDouble) * (n.toDouble/2D), 2)

    squareOfSum - sumOfSquares
  }
}
