object rationals {
  val x = new Rational(1, 3)                      //> x  : Rational = 1/3
  val y = new Rational(5, 7)                      //> y  : Rational = 5/7
  val z = new Rational(3, 2)                      //> z  : Rational = 3/2
  x.numer                                         //> res0: Int = 1
  x.denom                                         //> res1: Int = 3
  y.add(y)                                        //> res2: Rational = 10/7
  y.sub(y)                                        //> res3: Rational = 0/1
  x.max(y)                                        //> res4: Rational = 5/7
  new Rational(2)                                 //> res5: Rational = 2/1
}

class Rational(x: Int, y: Int) {
  require(y > 0, "denominator must be positive")
  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)
  private val g = gcd(x.abs, y.abs)
  def numer = x / g
  def denom = y / g

	def this(x: Int) = this(x, 1)

  def less(that: Rational) = this.numer * that.denom < that.numer * this.denom
  
  def max(that: Rational) = if (this.less(that)) that else this

	def add(that: Rational) =
		new Rational(numer * that.denom + that.numer * denom, denom * that.denom)

	def neg: Rational = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

	override def toString = numer + "/" + denom
}