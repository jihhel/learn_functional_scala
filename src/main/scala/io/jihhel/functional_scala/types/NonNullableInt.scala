package io.jihhel.functional_scala.types

case class NonNullableInt private (toInt: Int) extends AnyVal

object NonNullableInt {
  def apply(nb: Int): NonNullableInt = {
    if (nb == 0) throw new Exception("ça marche pas chef")

    new NonNullableInt(nb)
  }
}
