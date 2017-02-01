import scala.annotation.tailrec
// Factorial - non tail recursive

def factorial(n: Int): Int =
  if (n == 0) 1 else n * factorial(n - 1)

factorial(5)

// Factorial - tail recursive version
def tail_factorial(n: Int): Int = {
  @tailrec
  def factorialAccumulator(acc:Int, n: Int) : Int =
    if (n == 0) acc else factorialAccumulator(n * acc, n - 1)

  factorialAccumulator(1, n)
}

tail_factorial(5)
