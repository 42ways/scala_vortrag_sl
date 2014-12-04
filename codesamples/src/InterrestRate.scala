// from interestrate.scala
class InterrestRate(name: String, val rate: Int => Double) {
  def monthly(t: Int) = math.pow(1 + rate(t), 1.0 / 12.0) - 1
  override def toString() = name
}

object InterrestRate {
  object constant0 extends InterrestRate("constant0", Int => 0.0);
  object constant0175 extends InterrestRate("constant0175", Int => 0.0175);
  object constant02 extends InterrestRate("constant02", Int => 0.02)
  object constant03 extends InterrestRate("constant03", Int => 0.03)
  object constant04 extends InterrestRate("constant04", Int => 0.04)
}
