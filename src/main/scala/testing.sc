List((2,3), (5,3), (7,9), (1,5)).reduceLeft{ (carry, el) =>
  (carry._1 * carry._2) max (el._1 * el._2)
}