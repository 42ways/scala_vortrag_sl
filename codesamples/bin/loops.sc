// loops as tail recursion

object loops {

  def factorial(n: Int): Int = {
    def go(n: Int, acc: Int): Int =
      if (n <= 0) acc
      else go(n - 1, n * acc)

    go(n, 1)
  }                                               //> factorial: (n: Int)Int

  // alternative: reduce
  def factorial2(n: Int) = (1 to n).reduceLeft(_ * _)
                                                  //> factorial2: (n: Int)Int

  def fibonacci(n: Int): Int = {
    def go(n: Int, secondToLast: Int, last: Int): Int =
      if (n <= 0) 0
      else if (n == 1) last
      else go(n - 1, last, secondToLast + last)

    go(n, 0, 1)
  }                                               //> fibonacci: (n: Int)Int

}