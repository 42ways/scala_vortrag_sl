// Square root (Newton's method)

object sqrt {
  def sqrt(x: Double): Double = {

    def sqrtIter(guess: Double): Double = {
      println(guess)
      if (isGoodEnough(guess)) guess
      else sqrtIter(improve(guess))
    }

    def isGoodEnough(guess: Double): Boolean =
      Math.abs(guess * guess - x) / x < 0.001

    def improve(guess: Double): Double =
      (guess + x / guess) / 2

    sqrtIter(1.0)
  }                                               //> sqrt: (x: Double)Double


	sqrt(4)                                   //> 1.0
                                                  //| 2.5
                                                  //| 2.05
                                                  //| 2.000609756097561
                                                  //| res0: Double = 2.000609756097561
                                                  
	sqrt(2)                                   //> 1.0
                                                  //| 1.5
                                                  //| 1.4166666666666665
                                                  //| 1.4142156862745097
                                                  //| res1: Double = 1.4142156862745097
}