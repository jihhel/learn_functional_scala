package io.jihhel.functional_scala.refact.cart

trait Storage[A] {
  def flush(a: A): Unit
}
