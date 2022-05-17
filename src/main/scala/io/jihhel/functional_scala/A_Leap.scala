package io.jihhel.functional_scala

object A_Leap extends App {

  val name = "Jonathan"

  // Définir une fonction
  def salut(name: String): Unit = {
    println(s"Salut $name !")
  }

  salut(name)

  // Alternatives
  val plusUn = (nb: Int) => nb + 1
  val plusDeux = { nb: Int =>
    nb + 2
  }

  // curryfication
  def plus(a: Int)(b: Int): Int = a + b
  val plusAlternatif: Int => Int => Int = a => b => a + b

  //  Application partielle
  val newPlusUn: Int => Int = plus(1)


  // Passer des fonctions en paramètre
  def apply(nb: Int, f: Int => Int): Int = {
    f(nb)
  }

  println(apply(1, plusUn))
}
