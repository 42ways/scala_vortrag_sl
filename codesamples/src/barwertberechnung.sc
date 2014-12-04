import sterbetafeln._

object barwertberechnung {

  def i(d: Double) = 1 + d                        //> i: (d: Double)Double
  def v(d: Double) = 1 / i(d)                     //> v: (d: Double)Double

  def klassisches_qx(tafel: String, sex: String): Int => Double = klassische_sterbetafel(tafel, sex, _)
                                                  //> klassisches_qx: (tafel: String, sex: String)Int => Double

  def unisex_qx(tafel: String): Int => Double = unisex_sterbetafel(tafel, _)
                                                  //> unisex_qx: (tafel: String)Int => Double

  def bmi_qx(tafel: String, sex: String, groesse: Int, gewicht: Double): Int => Double = bmi_sterbetafel(tafel, sex, groesse, gewicht, _)
                                                  //> bmi_qx: (tafel: String, sex: String, groesse: Int, gewicht: Double)Int => Do
                                                  //| uble

  def barwert(zins: Int => Double, qx: Int => Double, spektrum: Int => Double)(von: Int, bis: Int, eintrittsAlter: Int): Double = {
    if (von > bis)
      0.0
    else
      spektrum(von) + (1.0 - qx(von + eintrittsAlter)) * v(zins(von)) * barwert(zins, qx, spektrum)(von + 1, bis, eintrittsAlter)
  }                                               //> barwert: (zins: Int => Double, qx: Int => Double, spektrum: Int => Double)(v
                                                  //| on: Int, bis: Int, eintrittsAlter: Int)Double

  val vp = Person("M", 175, 68, DateFactory(1990, 1, 1))
                                                  //> vp  : Person = Person(M,175,68.0,Thu Feb 01 00:10:22 CET 1990)

  val barwertBerechnungKlassisch =
    barwert(InterrestRate.constant0175.rate, klassisches_qx("2009/2011", vp.sex), Spektrum.yearly.fn)_
                                                  //> barwertBerechnungKlassisch  : (Int, Int, Int) => Double = <function3>
  println("Barwert klassisch  = " + barwertBerechnungKlassisch(0, 12, vp.age(DateFactory(2014, 1, 1))))
                                                  //> Barwert klassisch  = 1.805649110531689

  val barwertBerechnungUnisex =
    barwert(InterrestRate.constant0175.rate, unisex_qx("2009/2011"), Spektrum.yearly.fn)_
                                                  //> barwertBerechnungUnisex  : (Int, Int, Int) => Double = <function3>
  println("Barwert unisex  = " + barwertBerechnungUnisex(0, 12, vp.age(DateFactory(2014, 1, 1))))
                                                  //> Barwert unisex  = 1.8074131575530714

  val barwertBerechnungBmi =
    barwert(InterrestRate.constant0175.rate, bmi_qx("2009/2011", vp.sex, vp.groesse, vp.gewicht), Spektrum.yearly.fn)_
                                                  //> barwertBerechnungBmi  : (Int, Int, Int) => Double = <function3>
  println("Barwert bmi  = " + barwertBerechnungBmi(0, 12, vp.age(DateFactory(2014, 1, 1))))
                                                  //> Barwert bmi  = 1.805636078863772

}