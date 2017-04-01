// 3.2 : Objects as Functions

// 3.2.1 - the apply method
class Adder(amount: Int) {
  def apply(in: Int): Int = in + amount
}

val add3 = new Adder(3)
add3(2)

// 3.3 : Companion Objects
// Companion objects replace Java's static methods

class Timestamp(val seconds: Long)

object Timestamp {
  def apply(hours: Int,minutes: Int, seconds: Int): Timestamp =
    new Timestamp(hours*60*60 + minutes*60 + seconds)
}

Timestamp(1,1,1).seconds

Timestamp // companion object type is Timestamp.type

// Exercises
// 3.3.2.1 Friendly Person Factory
class Person(val firstName: String, val lastName: String)

object Person {
  def apply(name: String): Person = {
    val parts = name.split(" ")
    new Person(parts(0), parts(1))
  }
}

// 3.4 : Case Classes
// Whenever we declare a case class, Scala automatically
// generates a class and companion object

case class Person2(firstName: String, lastName: String) {
  def name = firstName + " " + lastName
}

val davethu = new Person2("Dave", "thu")
Person2

// a field for each argument
davethu.lastName

// default toString method
davethu.toString

// Sensible equals and hashCode methods that operate on field values
new Person2("Noel", "Welsh").equals(new Person2("Noel", "Welsh"))

// Exercises
// 3.4.5.1 Case Cats
case class Cat(colour: String,food: String)

// 3.4.5.2
// 3.4.5.3 Case Class Counter
case class Counter(count: Int = 0) {
  def inc = copy(count = count + 1)
  def dec = copy(count = count - 1)
}

// 3.5 : Pattern Matching
case class StarPerson(firstName: String, lastName: String)

object StormTrooper {
  def inspect(person: StarPerson): String =
    person match {
      case StarPerson("Luke", "Skywalker") => "Stop, rebel scum!"
      case StarPerson("Han", "Solo") => "Stop, rebel scum!"
      case StarPerson(first, last) => s"Move $first $last, you lazy scum!"
    }
}

StormTrooper.inspect(StarPerson("Noell", "Walsh"))

// Exercises
// 3.5.1 - Feed the Cats
object ChipShop {
  def willServe(cat: Cat): Boolean =
    cat match {
      case Cat(_, "Chips") => true
      case Cat(_, _) => false
    }
}