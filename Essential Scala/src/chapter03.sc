// Chapter 3 : Objects and Classes

// 3.1 : Classes are a template for creating objects that have
// similar methods and fields

class Person {
  val firstName = "Nooky"
  val lastName = "Wendy"

  def name = firstName + lastName
}

// create a new Person object
val nook = new Person
nook.firstName

// using methods to take class parameters
object alien {
  def greet(p: Person) =
    "Greetings, " + p.firstName + " " + p.lastName
}

alien.greet(nook)

// 3.1.2 - Constructors
class Person2(first: String, last: String) {
  val firstName = first
  val lastName = last

  def name = firstName + " " + lastName
}

// constructors short-hand
class Person3(val firstName: String, val lastName: String) {
  def name = firstName + " " + lastName
}

new Person3("Matt", "Henry").lastName

// 3.1.3 - Default and Keyword Parameters
new Person3(lastName = "last", firstName = "first") // keyword params

// default values for params
def greet(firstName: String = "some", lastName: String = "body") =
  "greetings, " + firstName + " " + lastName + " ;-)"

greet()

// 3.1.4: Scala's Type Hierarchy
def badness = throw new Exception("Error")
null

if (true) 123 else badness // Int is the least common supertype of Int and Nothing

if (false) "it worked" else null // String is the least common supertype of String and Null

// 3.1.6 : Exercises

class Cat(val colour: String, val food: String) {

}

val oswald = new Cat("Black", "Milk")
val henderson = new Cat("Ginger", "Chips")

// 3.1.6.2 Cats on the Prowl
object ChipShop {
  def willServe(cat: Cat): Boolean =
    if (cat.food == "Chips")
      true
    else
      false
}

val served = ChipShop.willServe(henderson)

// 3.1.6.3: Directorial Debut
class Director(val firstName: String, val lastName: String, val yearOfBirth: Int) {
  def name = firstName + " " + lastName
}

class Film(val name: String, val yearOfRelease: Int, val imdbRating: Double, val director: Director) {
  def directorsAge: Int = director.yearOfBirth - yearOfRelease

  def isDirectedBy(otherDirector: Director): Boolean =
    if (director.name.equals(otherDirector.name))
      true
    else
      false

  def copy(name: String = this.name,
           yearOfRelease: Int = this.yearOfRelease,
           imdbRating: Double = this.imdbRating,
           director: Director = this.director) =
    new Film(name, yearOfRelease, imdbRating, director)
}

val eastwood = new Director("Clint", "Eastwood", 1930)
val mcTiernan = new Director("John", "McTiernan", 1951)
val nolan = new Director("Christopher", "Nolan", 1970)
val someBody = new Director("Just", "Some Body", 1990)
val memento = new Film("Memento", 2000, 8.5, nolan)
val darkKnight = new Film("Dark Knight", 2008, 9.0, nolan)
val inception = new Film("Inception", 2010, 8.8, nolan)
val highPlainsDrifter = new Film("High Plains Drifter", 1973, 7.7, eastwood)
val outlawJoseyWales = new Film("The Outlaw Josey Wales", 1976, 7.9, eastwood)
val unforgiven = new Film("Unforgiven", 1992, 8.3, eastwood)
val granTorino = new Film("Gran Torino", 2008, 8.2, eastwood)
val invictus = new Film("Invictus", 2009, 7.4, eastwood)
val predator = new Film("Predator", 1987, 7.9, mcTiernan)
val dieHard = new Film("Die Hard", 1988, 8.3, mcTiernan)
val huntForRedOctober = new Film("The Hunt for Red October", 1990, 7.6, mcTiernan)
val thomasCrownAffair = new Film("The Thomas Crown Affair", 1999, 6.8, mcTiernan)

eastwood.yearOfBirth // should be 1930
dieHard.director.name // should be "John McTiernan"
invictus.isDirectedBy(nolan) // should be false

highPlainsDrifter.copy(name = "L'homme des hautes plaines")

thomasCrownAffair.copy(yearOfRelease = 1968,
  director = new Director("Norman", "Jewison", 1926))

inception.copy().copy().copy()

// 3.1.6.4 : Simple Counter
class Counter(val count: Int) {
  def inc = new Counter(count + 1)
  def dec = new Counter(count - 1)
}

new Counter(10).inc.dec.inc.inc.count

// 3.1.6.5 : Counting faster
class FastCounter(val count: Int) {
  def inc(incrementer: Int = 1) : FastCounter = new FastCounter(count + incrementer)
  def dec(incrementer: Int = 1) : FastCounter = new FastCounter(count - incrementer)
}

// 3.1.6.6 Additional Counting
class Adder(amount: Int) {
  def add(in: Int) = in + amount
}

class AdjustedCounter(val count: Int) {
  def inc(incrementer: Int = 1) : AdjustedCounter = new AdjustedCounter(count + incrementer)
  def dec(incrementer: Int = 1) : AdjustedCounter = new AdjustedCounter(count - incrementer)

  def adjust(adder: Adder) = new AdjustedCounter(adder.add(count))
}