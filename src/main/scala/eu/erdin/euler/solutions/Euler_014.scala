package eu.erdin.euler.solutions

import eu.erdin.euler.EulerSolution

/**
  * @author robert.erdin@gmail.com 
  *         created on 17/05/17.
  */
object Euler_014 extends EulerSolution {


  def collatzSequence(n: Long, length: Int): Long = {
    def nextCollatz(e: Long): Long = {
      if (e % 2 == 0) {
        return e / 2
      }
      e * 3 + 1
    }

    n match {
      case 1 => length + 1
      case _ => collatzSequence(nextCollatz(n), length + 1)
    }
  }


  override def answer(): Any = {
    var cache = collection.mutable.Map[Int,Long]()
    for (i <- 1 until 1000000){
      if (cache.contains(i)){
        // nothing
      }else {
        val len = collatzSequence(i,0)
        cache += (i -> len)
        if (i < 500000){
          cache += ((2*i) -> (len + 1))
        }
      }
    }

    cache.foldLeft((0,0L))((max, entry) => {
      if (entry._2 > max._2){
        entry
      }else{
        max
      }
    })._1
  }

}