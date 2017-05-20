package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

import scala.math.BigInt

/**
  * @author robert.erdin@gmail.com 
  *         created on 20/05/17.
  */
object Euler_015 extends EulerSolution{

  val Zero = BigInt(0)
  def fact(n: BigInt): BigInt = n match {
    case Zero => 1
    case _ => n * fact(n-1)
  }

  def binomCoeff(n: BigInt, k: BigInt): BigInt = {
    fact(n) / (fact(k) * fact(n - k))
  }

  // If you look at how many paths lead to each node in the grid you'll observe
  // that it resembles a pascal triangle that is tilted by 45°.
  // --> use the binomial coefficient to calculate the number of potential paths.
  override def answer(): Any = binomCoeff(40,20)
}
