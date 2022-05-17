package io.jihhel.functional_scala

import io.jihhel.functional_scala.types.NonNullableInt

import scala.util.Random

object F_Rna extends App {

  def divide(numerator: Int, denominator: NonNullableInt): Int = {
    numerator / denominator.toInt
  }

  Option(null) match {
    case Some(value) => println(s"Mon option contient $value")
    case None => println("Mon option est vide")
  }

  Option(42) match {
    case Some(value) => println(s"Mon option contient $value")
    case None => println("Mon option est vide")
  }

  Option(42).map(nb => nb + 1) // Some(43)

  val r = Option(Option(42)).flatten // Some(42)
  val s = Option(None).flatten // None

  val l: LazyList[(Int, Int)] = LazyList
    .continually(0)
    .take(3)
    .map(_ => (Random.nextInt(3), Random.nextInt(3)))

  l.map({ case (numerator, denominator) =>
    if (denominator == 0) {
      Option.empty[Int]
    } else {
      Option(numerator / denominator)
    }
  })

  //.flatten



  Option(5).filter(nb => nb > 2) // Some(5)
  Option(0).filter(nb => nb > 2) // None

  List(1, 10, 100).filter(nb => nb > 5) // List(10, 100)


  // Fonctions utiles sur les List / Map
  // List.find
  // List.forall
  // List.exists

}
