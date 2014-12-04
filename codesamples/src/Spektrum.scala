// from spektrum.scala
class Spektrum(val name: String, val fn: Int => Double, val faktor: () => Double)

object Spektrum {
  object yearly extends Spektrum("yearly", (month: Int) => if (month % 12 == 0) 1.0 else 0.0, () => 1.0)
  object quarterly extends Spektrum("quarterly", (month: Int) => if (month % 3 == 0) 1.0 else 0.0, () => 4.0)
  object monthly extends Spektrum("monthly", (month: Int) => 1.0, () => 12.0)
  object once extends Spektrum("once", (month: Int) => if (month == 0) 1.0 else 0.0, () => 0.0) // ?, das trifft es auch nicht so richtig
  object none extends Spektrum("none", Int => 0.0, () => 0.0)
}

