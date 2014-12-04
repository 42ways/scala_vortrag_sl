// Square root (Newton's method)

object sqrt {
  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double, x: Double): Double = {
      println(guess, x)
      if (isGoodEnough(guess, x)) guess
      else sqrtIter(improve(guess, x), x)
    }

    def isGoodEnough(guess: Double, x: Double): Boolean =
      Math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double, x: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0, x)
  }                                               //> sqrt: (x: Double)Double


	sqrt(4)                                   //> (1.0,4.0)
                                                  //| (2.5,4.0)
                                                  //| (2.05,4.0)
                                                  //| (2.000609756097561,4.0)
                                                  //| res0: Double = 2.000609756097561
}