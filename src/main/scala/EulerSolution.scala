/**
  * Created by robert on 07/10/16.
  */
abstract class EulerSolution {
  def answer(): Any

  def main(args: Array[String]) {
    val before = System.nanoTime()
    println(answer())
    print("Execution time: " + (System.nanoTime() - before) + "ns")
  }
}
