package io.jihhel.functional_scala

object G_Armstrong extends App {

  def foldLeft[A, B](list: List[A])(acc: B)(f: (B, A) => B): B = {
    list match {
      case Nil => acc
      case head :: tail =>
        val newAcc = f(acc, head)
        foldLeft(tail)(newAcc)(f)
    }
  }

  // Sum d'une liste
  List(1, 2, 3).foldLeft(0)({case (accumulator, currentElement) =>
    accumulator + currentElement
  }) // 6

  // Incrémenter éléments d'une liste
  List(1, 2, 3).foldLeft(List.empty[Int])({ case (acc, current) =>
    acc :+ (current + 1)
  }) // List(2, 3, 4)


}
