// 4.3 & 4.4 : The Product Type & Sum Type Pattern

// Product Type Pattern: model data that contains other data
// has-a and relationships
case class Car(color: String, mileage: Double)

trait Vehicle {
  def color: String
  def mileage: Double
}

// Sum Type Pattern : data that is two or more distinct cases
// A is a B or C
sealed trait A
final case class B() extends A
final case class C() extends A

// 4.4.2 : Missing Patterns
// is-a and pattern

trait B1
trait C1
trait A1 extends B1 with C1

// has-a or
trait A2 {
  def d: D2
}

sealed trait D2
final case class B2() extends D2
final case class C2() extends D2

// 4.4.4 : Exercises
// 4.4.4.1 : Stop on a Dime
sealed trait TrafficLight

final case object RedLight extends TrafficLight
final case object GreenLight extends TrafficLight
final case object YellowLight extends TrafficLight

// 4.4.4.2 : Calculator
sealed trait Calculation
final case class Success(result: Int) extends Calculation
final case class Failure(reason: String) extends Calculation

// 4.4.4.3: Water, Water, Everywhere
final case class BottledWater(size: Int, source: Source, carbonated: Boolean)

sealed trait Source
final case object Well extends Source
final case object Spring extends Source
final case object Tap extends Source


