package eu.erdin.euler

/**
  * For use in worksheets...
  */
object EulerTools {

  lazy val primeStream: Stream[Long] = 2L #:: Stream.from(3).map(_.toLong).filter(i =>
    primeStream.takeWhile { j => j * j <= i }.forall { k => i % k > 0 })

  def primeFactors(x: Long): List[Long] = {
    if (x == 1){
      return List()
    }
    def primeFactorHlpr(y: Long, currentPrimes: Stream[Long], factors: List[Long]): List[Long] = {
      if (y % currentPrimes.head == 0){
        if ( y == currentPrimes.head)
          return factors :+ currentPrimes.head
        primeFactorHlpr(y / currentPrimes.head, primeStream, factors :+ currentPrimes.head)
      } else {
        primeFactorHlpr(y, currentPrimes.tail, factors)
      }
    }
    primeFactorHlpr(x, primeStream, List())
  }

  def PrimeFactorization() = {
    ???
  }

}
