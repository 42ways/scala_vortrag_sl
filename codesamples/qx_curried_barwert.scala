:load sterbetafeln.scala
:paste qx_barwert_helper.scala

def klassisches_qx(tafel: String, sex: String): Int => Double = klassische_sterbetafel(tafel, sex, _)

def unisex_qx(tafel: String): Int => Double = unisex_sterbetafel(tafel, _)

def bmi_qx(tafel: String, sex: String, groesse: Int, gewicht: Double): Int => Double = bmi_sterbetafel(tafel, sex, groesse, gewicht, _)

// Der Barwert kann dabei immer identisch definiert sein
def  barwert(zins: Int => Double, qx: Int => Double, spektrum: Int => Double) (von: Int, bis: Int, eintrittsAlter: Int): Double = {
    if ( von > bis)
        0.0;
    else 
        spektrum(von) + (1.0 - qx(von + eintrittsAlter)) * v(zins(von)) * barwert(zins, qx, spektrum)(von + 1, bis, eintrittsAlter);
}

val vp = new Person("M", 175, 68, DateFactory(1990, 1, 1))

val barwertBerechnung = barwert(InterrestRate.constant0175.rate, klassisches_qx("2009/2011", vp.sex), Spektrum.yearly.fn)_
println ("Barwert klassisch  = " + barwertBerechnung(0, 12, vp.age(DateFactory(2014, 1, 1))))

val barwertBerechnung = barwert(InterrestRate.constant0175.rate, unisex_qx("2009/2011"), Spektrum.yearly.fn)_
println ("Barwert unisex  = " + barwertBerechnung(0, 12, vp.age(DateFactory(2014, 1, 1))))

val barwertBerechnung = barwert(InterrestRate.constant0175.rate, bmi_qx("2009/2011", vp.sex, vp.groesse, vp.gewicht), Spektrum.yearly.fn)_
println ("Barwert bmi  = " + barwertBerechnung(0, 12, vp.age(DateFactory(2014, 1, 1))))
