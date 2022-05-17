package io.jihhel.functional_scala

import io.jihhel.functional_scala.types.{ImmutablePerson, Person}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.concurrent.{Await, Future}
import scala.util.Random


object B_Immutability extends App {

  // Ex 1
  var p: Person = new Person("Toto", 42)

  Person.processPerson(p)

  println(p.age)


  val p2: ImmutablePerson = new ImmutablePerson("Tata", 22)

//  p2.age = 31

  // Ex 2

  val l1 = List(1, 2, 3)

  val l2 = l1 :+ 4

  val l3 = l2.map(nb => nb + 1)

  println(l1) // List(1, 2, 3)
  println(l2) // List(1, 2, 3, 4)
  println(l3) // List(2, 3, 4, 5)

  // Ex 3

  for (_ <- 1 to 10) {
    var cpt = 0

    val f1 = Future {
      Thread.sleep(500 * Random.nextInt(5))
      cpt = cpt + 1
      println(s"Le compteur dans la première future vaut $cpt")
    }

    val f2 = Future {
      Thread.sleep(500 * Random.nextInt(5))
      cpt = cpt + 1
      println(s"Le compteur dans la deuxième future vaut $cpt")
    }

    // On attend que les deux threads se terminent
    Await.result(f1.flatMap(_ => f2), Duration.Inf)
    println("=====================")
  }



}

