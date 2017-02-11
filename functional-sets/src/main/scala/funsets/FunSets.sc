
  /**
    * We represent a set by its characteristic function, i.e.
    * its `contains` predicate.
    */
  type Set = Int => Boolean

  /**
    * Indicates whether a set contains a given element.
    */
  def contains(s: Set, elem: Int): Boolean = s(elem)

  /**
    * Returns the set of the one given element.
    */
  def singletonSet(elem: Int): Set = (x: Int) => x == elem

  println(contains(singletonSet(1), 1))

 def union(s: Set, t: Set): Set = (x: Int) => s(x) || t(x)

  println(union(singletonSet(1), singletonSet(2)))


