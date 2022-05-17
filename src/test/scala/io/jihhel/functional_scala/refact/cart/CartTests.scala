package io.jihhel.functional_scala.refact.cart

import io.jihhel.functional_scala.refact.cart.CartProblem.applyDiscount
import io.jihhel.functional_scala.refact.cart.Models.{Amount, Cart, CartId, CustomerId}
import org.scalatest.funsuite.AnyFunSuite

class CartTests extends AnyFunSuite {

  test("happy path") {
    val cartId = CartId("some-gold-cart")
    val storage = new SpyStorage

    applyDiscount(cartId, storage)

    val expected = Cart(CartId("some-gold-cart"), CustomerId("gold-customer"), Amount(50))
    assert(storage.saved.get == expected)
  }

  test("no discount") {
    val cartId = CartId("some-normal-cart")
    val storage = new SpyStorage

    applyDiscount(cartId, storage)

    assert(storage.saved.isEmpty)
  }

  test("missing cart") {
    val cartId = CartId("missing-cart")
    val storage = new SpyStorage

    applyDiscount(cartId, storage)

    assert(storage.saved.isEmpty)
  }

  class SpyStorage extends Storage[Cart] {
    var saved: Option[Cart] = None
    override def flush(value: Cart): Unit = saved = Some(value)
  }

}