package eu.erdin.euler

import java.text.DecimalFormat

/**
  * Created by robert on 07/10/16.
  */
abstract class EulerSolution {

  val df = new DecimalFormat("#")
  df.setMaximumFractionDigits(8)

  def answer(): Any

  def main(args: Array[String]) {
    val before = System.nanoTime()
    println(df.format(answer()))
    print("Execution time: " + (System.nanoTime() - before) + "ns")
  }
}
