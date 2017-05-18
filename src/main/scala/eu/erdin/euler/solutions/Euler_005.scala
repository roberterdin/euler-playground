package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

/**
  * Created by robert on 08/10/16.
  */
object Euler_005 extends EulerSolution {
  val boundary = 20

  override def answer(): Any = {
//    TODO: find more efficient solution. Maybe https://en.wikipedia.org/wiki/Sieve_of_Atkin helps
    version1()
  }

  /**
    * Basically Sieve of Eratosthenes
    *
    * @return
    */
  def version1(): Any = {
    def smallMults(s: Stream[Int], carry: Int): Stream[Int] = {
      if (carry <= boundary)
        smallMults(s filter {
          _ % carry == 0
        }, carry + 1)
      else
        s
    }
    smallMults(Stream.from(2, 2), 1).head
  }

  def version2(): Any = {
    Stream.from(boundary, 2)
      .filter { el => (2 to boundary).forall(el % _ == 0) }
      .head
  }
}
