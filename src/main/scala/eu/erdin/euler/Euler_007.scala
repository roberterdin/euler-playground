package eu.erdin.euler

/**
  * Created by robert on 09/10/16.
  */
object Euler_007 extends EulerSolution {
  override def answer(): Any = {
    lazy val primeStream: Stream[Long] = 2L #:: Stream.from(3).map(_.toLong).filter(i =>
      primeStream.takeWhile { j => j * j <= i }.forall { k => i % k > 0 })

    primeStream drop 10000 head
  }
}
