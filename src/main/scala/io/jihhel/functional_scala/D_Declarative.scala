package io.jihhel.functional_scala

import scala.collection.mutable.ListBuffer

object D_Declarative extends App {

  // Ex 1

  def incrElementsProcedural(l: ListBuffer[Int]): Unit = {
    for (idx <- 0 to l.size) {
      l(idx) = l(idx) + 1
    }
  }

  def incrElementsDeclarative(l: List[Int]): List[Int] = {
    l.map(nb => nb + 1)
  }


  // Ex 2

  def getEvenElementsProcedural(l: ListBuffer[Int]): ListBuffer[Int] = {
    val evens = ListBuffer.empty[Int]

    for (idx <- 0 to l.size) {
      if (l(idx) % 2 == 0) {
        evens.addOne(l(idx))
      }
    }

    evens
  }

  def getEvenElementsDeclarative(l: List[Int]): List[Int] = {
    l.filter(nb => nb % 2 == 0)
  }

  // Ex 3 : composition

  def getEvenElementsAndIncrImperative(l: ListBuffer[Int]): ListBuffer[Int] = {
    val evens = ListBuffer.empty[Int]

    for (idx <- 0 to l.size) {
      if (l(idx) % 2 == 0) {
        evens.addOne(l(idx) + 1)
      }
    }

    evens
  }

  def isEven(nb: Int) = nb % 2 == 0
  def incr(nb: Int) = nb + 1

  def getEvenElementsAndIncrDeclarative(l: List[Int]): List[Int] = {
    l
      .filter(isEven)
      .map(incr)
  }


}
