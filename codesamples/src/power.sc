// compute x ^ n

object power {

  def isEven(n: Int) = n % 2 == 0                 //> isEven: (n: Int)Boolean

  def power(x: Double, n: Int): Double =
    n match {
      case 0              => 1
      case _ if n < 0     => 1 / power(x, -n)
      case _ if isEven(n) =>
        val y = power(x, n / 2); y * y
      case _              => x * power(x, n - 1)
    }                                             //> power: (x: Double, n: Int)Double

}