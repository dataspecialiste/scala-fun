// Expressions, Types, and Values

// 2.1 First Program
"Hello world!"

"Hello world!".toUpperCase

// Exercises - 2.1.4.1
1 + 2

"3".toInt

// "foo".toInt // causes error java.lang.NumberFormatException

// 2.2 Interacting with Objects
"hello".toUpperCase

"abcdef".take(3)

// 2.2.3 Operators
123.toShort

"the quick brown fox" split " " // infix operator notation

// Exercises - 2.2.5
// Operator Style
"foo".take(1)

"foo" take 1

1 + 2 + 3

1.+(2).+(3)

// 2.3 : Literal Objects

42

42.0

42.0f

42L

'a' // character

"strings"

null

// 2.3.6 : Unit equivalent to void in Java
()

println("Hello World")

// 2.4 : Object Literals

object Test {}

// 2.4.1 : Methods
object Test2 {
  def name: String = "just another object"
}

Test2.name

object Test3 {
  def hello(name: String) = "Hello " + name
}

Test3.hello("Jessica")

// 2.4.2 : Fields
object Test4 {
  val name = "Noel"
  def hello(friend: String): String =
    name + " says hi to " + friend
}

Test4.hello("Dave")

// Exercises - 2.4.5

object calc {
  def square(input: Double) = input * input

  def cube(input: Double) = square(input) * input
}

calc.square(3)
calc.cube(3)


object calc2 {
  def square(value: Double) = value * value
  def cube(value: Double) = value * square(value)
  def square(value: Int) = value * value
  def cube(value: Int) = value * square(value)
}

// 2.6 : Compound Expressions
// Conditionals
if (1 < 2)
  println("Yes")
else
  println("No")

// Blocks
// For side-effects
{
  println("This is a side-effect")
  println("This is a side-effect as well")
  3
}
// To store intermediate results
def name: String = {
  val title = "Professor"
  val name = "Funkenstein"
  title + " " + name
}
