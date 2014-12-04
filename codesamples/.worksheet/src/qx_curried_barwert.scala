import sterbetafeln._
import qx_barwert_helper._

object qx_curried_barwert {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(105); 

  def i(d: Double) = 1 + d;System.out.println("""i: (d: Double)Double""");$skip(30); 
  def v(d: Double) = 1 / i(d);System.out.println("""v: (d: Double)Double""");$skip(105); 

  def klassisches_qx(tafel: String, sex: String): Int => Double = klassische_sterbetafel(tafel, sex, _);System.out.println("""klassisches_qx: (tafel: String, sex: String)Int => Double""");$skip(78); 

  def unisex_qx(tafel: String): Int => Double = unisex_sterbetafel(tafel, _);System.out.println("""unisex_qx: (tafel: String)Int => Double""");$skip(139); 

  def bmi_qx(tafel: String, sex: String, groesse: Int, gewicht: Double): Int => Double = bmi_sterbetafel(tafel, sex, groesse, gewicht, _);System.out.println("""bmi_qx: (tafel: String, sex: String, groesse: Int, gewicht: Double)Int => Double""");$skip(307); 

  def barwert(zins: Int => Double, qx: Int => Double, spektrum: Int => Double)(von: Int, bis: Int, eintrittsAlter: Int): Double = {
    if (von > bis)
      0.0;
    else
      spektrum(von) + (1.0 - qx(von + eintrittsAlter)) * v(zins(von)) * barwert(zins, qx, spektrum)(von + 1, bis, eintrittsAlter);
  };System.out.println("""barwert: (zins: Int => Double, qx: Int => Double, spektrum: Int => Double)(von: Int, bis: Int, eintrittsAlter: Int)Double""");$skip(62); 

  val vp = new Person("M", 175, 68, DateFactory(1990, 1, 1));System.out.println("""vp  : qx_barwert_helper.Person = """ + $show(vp ));$skip(139); 

  val barwertBerechnungKlassisch =
    barwert(InterrestRate.constant0175.rate, klassisches_qx("2009/2011", vp.sex), Spektrum.yearly.fn)_;System.out.println("""barwertBerechnungKlassisch  : (Int, Int, Int) => Double = """ + $show(barwertBerechnungKlassisch ));$skip(104); 
  println("Barwert klassisch  = " + barwertBerechnungKlassisch(0, 12, vp.age(DateFactory(2014, 1, 1))));$skip(123); 

  val barwertBerechnungUnisex =
    barwert(InterrestRate.constant0175.rate, unisex_qx("2009/2011"), Spektrum.yearly.fn)_;System.out.println("""barwertBerechnungUnisex  : (Int, Int, Int) => Double = """ + $show(barwertBerechnungUnisex ));$skip(98); 
  println("Barwert unisex  = " + barwertBerechnungUnisex(0, 12, vp.age(DateFactory(2014, 1, 1))));$skip(149); 

  val barwertBerechnungBmi =
    barwert(InterrestRate.constant0175.rate, bmi_qx("2009/2011", vp.sex, vp.groesse, vp.gewicht), Spektrum.yearly.fn)_;System.out.println("""barwertBerechnungBmi  : (Int, Int, Int) => Double = """ + $show(barwertBerechnungBmi ));$skip(92); 
  println("Barwert bmi  = " + barwertBerechnungBmi(0, 12, vp.age(DateFactory(2014, 1, 1))))}

}
