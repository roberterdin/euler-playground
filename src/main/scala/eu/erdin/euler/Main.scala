package eu.erdin.euler

import better.files._, Cmds._
import java.io.{File => JFile}
import java.text.DecimalFormat

/**
  * Hacky class to automatically generate README. Do not run in front of children ;)
  */
object Main {

  val dfSolutions = new DecimalFormat("0")
  dfSolutions.setMaximumFractionDigits(4)

  val dfSolutionNumber = new DecimalFormat("000")

  val solutionDir = File("src/main/scala/eu/erdin/euler/solutions")

  val readmeFile = File("README.md")
  val rawReadme = File("raw_readme.md")

  def objectInitializer[T](name: String)(implicit man: Manifest[T]): T =
    Class.forName(name + "$").getField("MODULE$").get(man.erasure).asInstanceOf[T]

  def main(args: Array[String]): Unit = {
    readmeFile.clear()
    scala.io.Source.fromInputStream(rawReadme.newInputStream).mkString >>: readmeFile

    "## Answers" >>: readmeFile
    "| Problem   | Answer   | Cold JVM   | Warm JVM   |" >>: readmeFile
    "| ------------- |:-------------:|:-----:|:-----:|" >>:readmeFile


    println("Problem \t Answer \t Cold JVM")
    for (i <- 1 to ls(solutionDir).toList.length) {
      val solution = objectInitializer[EulerSolution](s"eu.erdin.euler.solutions.Euler_${dfSolutionNumber.format(i)}")
      val before = System.nanoTime()
      val answer = solution.answer()
      val after = System.nanoTime()
      val coldJvmTime = dfSolutions.format((after - before).toDouble / 1000000D)
      val answerString = dfSolutions.format(answer)

      println(s"$i \t\t\t $answerString \t ${coldJvmTime}ms")
      s"| $i | $answerString | ${coldJvmTime}ms | |" >>: readmeFile
    }

    "Scala " + scala.util.Properties.versionString >>: readmeFile
    "/ JVM version " + scala.util.Properties.javaVmVersion >>: readmeFile
  }

}
