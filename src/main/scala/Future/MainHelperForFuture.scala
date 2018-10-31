package Future

import scala.concurrent.ExecutionContext.Implicits.global

object MainHelperForFuture {

  def callForFutures(): Unit = {
    println("Coffee sequentially")
    Coffee.prepareCappuccinoSequentially()
    println("Coffee concurrently")
    Coffee.prepareCappuccinoConcurrently()
  }
}
