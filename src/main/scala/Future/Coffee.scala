package Future

import scala.concurrent.Future
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global

object Coffee {

  type CoffeeBeans = String
  type GroundCoffee = String
  case class Water(temperature: Int)
  type Milk = String
  type FrothedMilk = String
  type Espresso = String
  type Cappuccino = String

  case class GrindingException(msg: String) extends Exception(msg)
  case class FrothingException(msg: String) extends Exception(msg)
  case class WaterBoilingException(msg: String) extends Exception(msg)
  case class BrewingException(msg: String) extends Exception(msg)

  def grind(beans: CoffeeBeans): Future[GroundCoffee] = Future {
    println("start grinding")
    Thread.sleep(Random.nextInt(2000))
    if(beans == "baked beans") throw GrindingException("are you joking")
    println("finished grinding")
    s"ground coffee of $beans"
  }

  def heatWater(water: Water): Future[Water] = Future {
    println("heating the water now")
    Thread.sleep(Random.nextInt(2000))
    println("hot, it's hot!")
    water.copy(temperature = 85)
  }

  def frothMilk(milk: Milk): Future[FrothedMilk] = Future {
    println("milk frothing system engaged!")
    Thread.sleep(Random.nextInt(2000))
    println("shutting down milk frothing system")
    s"frothed $milk"
  }

  def brew(coffee: GroundCoffee, heatedWater: Water): Future[Espresso] = Future {
    println("happy brewing :)")
    Thread.sleep(Random.nextInt(2000))
    println("it's brewed!")
    "espresso"
  }

  def combine(espresso: Espresso, milk: FrothedMilk): Future[Cappuccino] = Future {
    println("Starting final step")
    Thread.sleep(Random.nextInt(2000))
    println("it's done...here it is Cappuccino!")
    "cappuccino"
  }

  grind("baked beans").onComplete {
    case Success(ground) => println(s"got my $ground")
    case Failure(ex) => println("This grinder needs a replacement, seriously!")
  }

  val tempOk: Future[Boolean] = heatWater(Water(25)).map { water =>
    println("we are in the future")
    (80 to 85).contains(water.temperature)
  }

  def temperatureOk(water: Water): Future[Boolean] = Future {
    (80 to 85).contains(water.temperature)
  }

  val nestedFuture: Future[Future[Boolean]] = heatWater(Water(25)).map {
    water => temperatureOk(water)
  }
  val flatFuture: Future[Boolean] = heatWater(Water(25)).flatMap {
    water => temperatureOk(water)
  }

  def prepareCappuccinoSequentially(): Future[Future[Cappuccino]] = {
    for {
      ground <- grind("arabica beans")
      water <- heatWater(Water(20))
      foam <- frothMilk("milk")
      espresso <- brew(ground, water)
    } yield combine(espresso, foam)
  }

  def prepareCappuccinoConcurrently(): Future[Future[Cappuccino]] = {
    val groundCoffee = grind("arabica beans")
    val heatedWater = heatWater(Water(20))
    val frothedMilk = frothMilk("milk")
    for {
      ground <- groundCoffee
      water <- heatedWater
      foam <- frothedMilk
      espresso <- brew(ground, water)
    } yield combine(espresso, foam)
  }
}
