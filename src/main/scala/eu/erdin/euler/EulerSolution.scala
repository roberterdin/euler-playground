package eu.erdin.euler

import java.text.DecimalFormat

/**
  * Created by robert on 07/10/16.
  */
abstract class EulerSolution {

  val df = new DecimalFormat("#")
  df.setMaximumFractionDigits(8)

  def answer(): Any

  lazy val primeStream: Stream[Long] = 2L #:: Stream.from(3).map(_.toLong).filter(i =>
    primeStream.takeWhile { j => j * j <= i }.forall { k => i % k > 0 })

  def main(args: Array[String]) {
    val before = System.nanoTime()
    println(df.format(answer()))
    print("Execution time: " + (System.nanoTime() - before) + "ns")
  }
}
