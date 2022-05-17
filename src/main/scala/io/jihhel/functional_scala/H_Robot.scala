package io.jihhel.functional_scala

object H_Robot extends App {

  case class Text(title: Option[String], content: Option[String])










  sealed trait TextS

  case object EmptyText extends TextS
  case class Note(content: String) extends TextS
  case class Book(title: String, content: String, nbPages: Int) extends TextS
  case class Trilogy(b1: Book, b2: Book, b3: Book) extends TextS
  case class Thesis(title: String, content: String, domain: String) extends TextS








  sealed trait ThesisDomain
  case object Biology extends ThesisDomain
  case object Math extends ThesisDomain
  case object Physics extends ThesisDomain
  case object ComputerScience extends ThesisDomain


  case class ThesisD(title: String, content: String, domain: ThesisDomain) extends TextS


  def isComputerScienceThesis(t: TextS): Boolean = t match {
    case ThesisD(_, _, ComputerScience) => true
    case _ => false
  }

  val test = Book("1984", "a very long text", 512)
  val test2 = ThesisD("A study of Turing's Test", "the thesis content", ComputerScience)

  println(isComputerScienceThesis(test)) // false
  println(isComputerScienceThesis(test2)) // true





}
