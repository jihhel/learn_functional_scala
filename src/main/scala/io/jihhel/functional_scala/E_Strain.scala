package io.jihhel.functional_scala

import scala.annotation.tailrec
import scala.util.Random

object E_Strain extends App {

  Random.nextInt(5) match {
    case 2 => println("C'est 2")
    case 1 => println("C'est un beau 1")
  }

  val listSize = List.fill(Random.nextInt(3))(0) match {
    case Nil => 0
    case list if list.size == 1 => 1
    case a :: b :: Nil => a + b
    case bigList => bigList.sum
  }


  def sum(l: List[Int]): Int = {
    l match {
      case head :: tail => head + sum(tail)
      case Nil => 0
    }
  }

  println(sum(List(1, 2, 3)))

  def sumRange(n: Int): Int = {
    n match {
      case 0 => 0
      case _ => sumRange(n - 1) + n
    }
  }

  println(sumRange(5))

  def sumRange2(n: Int): Int = {
    _sumRange2(n, 0)
  }

  @tailrec
  def _sumRange2(n: Int, total: Int): Int = {
    n match {
      case 0 => total
      case _ => _sumRange2(n - 1, total + n)
    }
  }

  println(sumRange2(5))

}
