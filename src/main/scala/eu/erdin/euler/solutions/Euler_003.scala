package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

/**
  * Created by robert on 07/10/16.
  */
object Euler_003 extends EulerSolution{
  override def answer(): Any = {
    //  Prime factors of 13195
    //  5, 7, 13 and 29.

    val target = 600851475143L
//    val target: Long = 13195

//    def primeStream(s: Stream[Long]): Stream[Long] =
//      s.head #:: primeStream(s.tail filter { _ % s.head != 0 })

    lazy val primeStream: Stream[Long] = 2L #:: Stream.from(3).map(_.toLong).filter(i =>
      primeStream.takeWhile{j => j * j <= i}.forall{ k => i % k > 0})

    def primeFactors(x: Long, currentPrimes: Stream[Long]) : Long = {

      if (x % currentPrimes.head == 0){
        if ( x == currentPrimes.head)
          return x
        primeFactors(x / currentPrimes.head, primeStream)
      } else {
        primeFactors(x, currentPrimes.tail)
      }
    }
    primeFactors(target, primeStream)
  }
}
