// 4.1 - Traits
// Templates for creating classes
import java.util.Date

trait Visitor {
  def id: String
  def createdAt: Date

  // How long has this visitor been around?
  def age: Long = new Date().getTime - createdAt.getTime
}

case class Anonymous(id: String, createdAt: Date = new Date()) extends Visitor

case class User(
               id: String,
               email: String,
               createdAt: Date = new Date()
               ) extends Visitor

def older(v1: Visitor, v2: Visitor): Boolean =
  v1.createdAt.before(v2.createdAt)

older(Anonymous("1"), User("2", "test@example.com"))

// Exercises
// 4.1.4.1 - Cats, and more Cats
trait Feline {
  def colour: String
  def sound: String
}

trait BigCat extends Feline {
  def sound = "roar"
}

case class Cat(colour: String, favoriteFood: String) extends Feline {
  val sound = "meow"
}
case class Lion(colour: String, maneSize: Int) extends BigCat

// 4.1.4.2 - Shaping up with Traits
sealed trait Shape{
  def sides: Int
  def perimeter: Double
  def area: Double
}

case class Rectangle(length: Double, breadth: Double) extends Shape {
  val sides = 4
  def perimeter:Double = 2 * (length + breadth)
  def area: Double = length * breadth
}

case class Square(length: Double) extends Shape {
  val sides = 4
  def perimeter:Double = 4 * length
  def area: Double = length * length
}

case class Circle(radius: Double) extends Shape {
  val sides = 1
  def perimeter: Double = 2 * math.Pi * radius
  def area:Double = math.Pi * radius * radius

}

// 4.2 - Sealed Traits
object Draw {
  def apply(shape: Shape): String =
    shape match {
      case Circle(radius) => s"A circle of radius $radius"
      case Rectangle(length, breadth) => s"A rectangle of length $length and $breadth"
      case Square(length) => s"A square of side length $length"
    }

}

Draw(Circle(10))

// Exercise 4.2.2.2
sealed trait Color {
  def red: Double
  def green: Double
  def blue: Double

  // We decided to define a "light" colour as one with
  // an average RGB of more than 0.5:
  def isLight: Boolean = (red + green + blue) / 3.0 > 0.5
  def isDark: Boolean = !isLight
}

final object Red extends Color {
  val red = 255
  val green = 0
  val blue = 0
}

final case class CustomColor(red: Double, green: Double, blue: Double) extends Color

// Exercise 4.2.2.3
sealed trait DivisionResult {
  def result: String
}

class Finite(value: Int) extends DivisionResult {
  val result = s"Finite($value)"

  override def toString: String = result
}

class Infinite extends DivisionResult {
  val result = "Infinite"

  override def toString: String = result
}

object divide {
  def apply(numerator: Int, denominator: Int): DivisionResult = {
    if (denominator == 0)
      new Infinite
    else
      new Finite(numerator / denominator)
  }
}

divide(10, 5)
divide(10, 0)
