package eu.erdin.euler

import better.files._
import java.io.{File => JFile}
import java.text.DecimalFormat

/**
  * Created by robert on 08/10/16.
  */
object Main {

  val df = new DecimalFormat("0")
  df.setMaximumFractionDigits(4)

  val readmeFile = File("README.md")
  val rawReadme = File("raw_readme.md")

  def objectInitializer[T](name: String)(implicit man: Manifest[T]): T =
    Class.forName(name + "$").getField("MODULE$").get(man.erasure).asInstanceOf[T]

  def main(args: Array[String]): Unit = {
    readmeFile.clear()
    scala.io.Source.fromInputStream(rawReadme.newInputStream).mkString >>: readmeFile

    "## Answers" >>: readmeFile
    "| Problem   | Answer   | Cold JVM   | Warm JVM   |" >>: readmeFile
    "| ------------- |:-------------:| -----:|-----:|" >>:readmeFile


    println("Problem \t Answer \t Cold JVM")
    for (i <- 1 to 8) {
      val solution = objectInitializer[EulerSolution](s"eu.erdin.euler.Euler_00$i")
      val before = System.nanoTime()
      val answer = solution.answer()
      val after = System.nanoTime()
      val coldJvmTime = df.format((after - before).toDouble / 1000000D)
      val answerString = df.format(answer)

      println(s"$i \t\t\t $answerString \t ${coldJvmTime}ms")
      s"| $i | $answerString | ${coldJvmTime}ms | |" >>: readmeFile
    }

    "Scala " + scala.util.Properties.versionString >>: readmeFile
    "JVM version " + scala.util.Properties.javaVmVersion >>: readmeFile
  }

}
