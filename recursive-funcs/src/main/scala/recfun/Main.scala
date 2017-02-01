package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
    * Exercise 1
    * The numbers at the edge of the triangle are all 1, and each number
    * inside the triangle is the sum of the two numbers above it. Write a
    * function that computes the elements of Pascal’s triangle by means
    * of a recursive process.
    * *
    * The pascal function in Main.scala, which takes a column c and a row r,
    * counting from 0 and returns the number at that spot in the triangle.
    * For example, pascal(0,2)=1,pascal(1,2)=2 and pascal(1,3)=3.
    *
    */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c >= r)
      1
    else
      pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
    * Exercise 2
    * Write a recursive function which verifies the balancing of parentheses
    * in a string, which we represent as a List[Char] not a String. For
    * example, the function should return true for the following strings:
    *
    * (if (zero? x) max (/ 1 x))
    * I told him (that it’s not (yet) done). (But he wasn’t listening)
    * The function should return false for the following strings:
    * *
    * :-)
    * ())(
    * The last example shows that it’s not enough to verify that a string
    * contains the same number of opening and closing parentheses.
    *
    */
  def balance(chars: List[Char]): Boolean = {

  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = ???
}
