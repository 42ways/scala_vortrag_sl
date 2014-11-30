
import java.util.{Calendar, Date}

object DateFactory {
  def apply(year: Int, month: Int = 1, date: Int = 1) = {
    val cal = Calendar.getInstance()
    cal.set(year, month, date)
    cal.getTime
  }
}
// from spektrum.scala
sealed class Spektrum(val name: String, val fn: Int => Double, val faktor: () => Double)

object Spektrum {
    object yearly    extends Spektrum( "yearly",   (month : Int) => if ( month % 12 == 0) 1.0 else 0.0, () => 1.0)
 	object quarterly extends Spektrum( "quarterly",(month : Int) => if ( month %  3 == 0) 1.0 else 0.0, () => 4.0)
 	object monthly   extends Spektrum( "monthly",  (month : Int) => 1.0                               , () => 12.0)
 	object once      extends Spektrum( "once",     (month : Int) => if (month == 0) 1.0 else 0.0,       () => 0.0) // ?, das trifft es auch nicht so richtig
    object none      extends Spektrum( "none",              Int  => 0.0,                                () => 0.0)
}

// from interestrate.scala
sealed class InterrestRate(name: String, val rate: Int => Double) {
    def monthly ( t :Int) = math.pow(1 + rate(t), 1.0/12.0) -1
    override def  toString() = name
}

object InterrestRate {
  object constant0    extends InterrestRate( "constant0",    Int => 0.0);
  object constant0175 extends InterrestRate( "constant0175", Int => 0.0175);
  object constant02   extends InterrestRate( "constant02",   Int => 0.02)
  object constant03   extends InterrestRate( "constant03",   Int => 0.03)
  object constant04   extends InterrestRate( "constant04",   Int => 0.04 )
}

sealed class Person(val sex: String, val groesse: Int, val gewicht: Double, val birthDate: Date) {
    def age(at: Date) = at.getYear - birthDate.getYear
}

// Zins
def i(d: Double) = 1 + d
 
// Diskont
def v(d: Double) = 1 / i(d)
