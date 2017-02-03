package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }

    println("Matching Parentheses")
    println(balance("(if (zero? x) max (/ 1 x))".toList))
    println(balance("())(".toList))
    println(balance(":-)".toList))

    println("Counting Coins")
    println(countChange(3, List(2, 1)))

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
    *
    * :-)
    * ())(
    * The last example shows that it’s not enough to verify that a string
    * contains the same number of opening and closing parentheses.
    *
    */
  def balance(chars: List[Char]): Boolean = {
    def checkParentheses(balance: Int, characters: List[Char]): Int = {
      if (balance < 0 || characters.isEmpty)
        balance
      else {
        if (characters.head == '(')
          checkParentheses(balance + 1, characters.tail)
        else if (characters.head == ')')
          checkParentheses(balance - 1, characters.tail)
        else
          checkParentheses(balance, characters.tail)
      }
    }

    checkParentheses(0, chars) == 0

  }

  /**
    * Exercise 3
    * Write a recursive function that counts how many different ways you
    * can make change for an amount, given a list of coin denominations.
    * For example, there are 3 ways to give change for 4 if you have coins
    * with denomination 1 and 2: 1+1+1+1, 1+1+2, 2+2.
    *
    * Hint: Think of the degenerate cases.
    * How many ways can you give change for 0 CHF(swiss money)?
    * How many ways can you give change for >0 CHF, if you have no coins?
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0 || coins.isEmpty)
      0
    else if (money == 0) 1
    else
      countChange(money - coins.head, coins) + countChange(money, coins.tail)

  }
}
