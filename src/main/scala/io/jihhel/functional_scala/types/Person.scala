package io.jihhel.functional_scala.types

class Person(var name: String, var age: Int)

object Person {
  def processPerson(p: Person): Unit = {
    p.age = 43
  }
}