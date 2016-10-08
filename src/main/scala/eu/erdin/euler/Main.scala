package eu.erdin.euler

import better.files._
import java.io.{File => JFile}

/**
  * Created by robert on 08/10/16.
  */
object Main {

  def objectInitializer[T](name: String)(implicit man: Manifest[T]): T =
    Class.forName(name + "$").getField("MODULE$").get(man.erasure).asInstanceOf[T]

  val readmeFile = File("README.md")
  val rawReadme = File("raw_readme.md")

  def main(args: Array[String]): Unit = {
    readmeFile.clear()
    scala.io.Source.fromInputStream(rawReadme.newInputStream).mkString >>: readmeFile

    "## Answers" >>: readmeFile
    "| Problem   | Answer   | Cold JVM   | Warm JVM   |" >>: readmeFile
    "| ------------- |:-------------:| -----:|-----:|" >>:readmeFile


    println("Problem \t Answer \t Cold JVM")
    for (i <- 1 to 5) {
      val solution = objectInitializer[EulerSolution](s"eu.erdin.euler.Euler_00$i")
      val before = System.nanoTime()
      val answer = solution.answer()
      val after = System.nanoTime()
      println(s"$i \t\t\t $answer \t ${(after - before) / 1000000}ms")

      s"| $i | $answer | ${(after - before) / 1000000}ms | |" >>: readmeFile
    }

    "Scala " + scala.util.Properties.versionString + "\n" >>: readmeFile
    "JVM version " + scala.util.Properties.javaVmVersion + "\n" >>: readmeFile
  }

}
