package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

/**
  * Created by robert on 09/10/16.
  */
object Euler_010 extends EulerSolution{
  override def answer(): Any = primeStream.takeWhile(_ < 2000000L).sum
}
