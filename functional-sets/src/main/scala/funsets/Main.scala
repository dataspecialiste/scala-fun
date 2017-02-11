package funsets

object Main extends App {
  import FunSets._
  println(contains(singletonSet(1), 1))

  println(union(singletonSet(1), singletonSet(2)))

  println(intersect(singletonSet(2), singletonSet(2)))
}
