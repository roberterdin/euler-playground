package eu.erdin.euler.solutions

import eu.erdin.euler.{EulerSolution, EulerTools}

/**
  * Created by robert on 12/10/16.
  */
object Euler_012 extends EulerSolution {

  private def noOfFactors(x: Int): Int = {
    val primeFactors = EulerTools.primeFactors(x)
    if (primeFactors.length == 1){
      // is prime
      return 1
    }
    primeFactors.foldLeft(Map[Int,Int]())((acc, el) => {
      acc.updated(el.toInt, acc.getOrElse[Int](el.toInt, 1) + 1)
    }).values.product
  }

  def trianNumber(n: Int): Int = {
    n * (n + 1) / 2
  }

  override def answer(): Any = {

    def findTriangularIndex(i: Int, lnum: Int, rnum: Int, limit: Int): Int = {
      val llnum = rnum
      val rrnum = noOfFactors(trianNumber(i+1))
      if (lnum * rnum < limit){
        findTriangularIndex(i+1, rrnum, llnum, limit)
      } else {
        i
      }
    }
    trianNumber(findTriangularIndex(1, noOfFactors(trianNumber(1)), noOfFactors(trianNumber(2)), 501))
  }
}
