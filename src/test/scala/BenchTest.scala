import eu.erdin.euler._
import eu.erdin.euler.solutions.Euler_005
import org.scalameter.api._

/**
  * Created by robert on 08/10/16.
  */
object BenchTest extends Bench.LocalTime {

  performance of "Euler" in {
    measure method "answer" in {
      using(Gen.unit("")) in {
        (_) =>
          Euler_005.answer()
      }
    }
  }

}
