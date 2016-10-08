package eu.erdin.euler

/**
  * Created by robert on 07/10/16.
  */
object Euler_002 extends EulerSolution{
  override def answer(): Any = {
    def fib: Stream[Int] = 1 #:: fib.scanLeft(2)(_ + _)
    fib filter (_ % 2 == 0) takeWhile (_ < 4000000) sum
  }
}