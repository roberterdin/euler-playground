package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

/**
  * Created by robert on 07/10/16.
  */
object Euler_001 extends EulerSolution {

  override def answer(): Any = (1 until 1000).filter(e => e % 3 == 0 || e % 5 == 0).sum

}