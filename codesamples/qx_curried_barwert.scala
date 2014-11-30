import sterbetafeln

def klassisches_qx(tafel: String, sex: String): Int => Double = klassische_sterbetafel(tafel, sex, _)

def unisex_qx(tafel: String): Int => Double = unisex_sterbetafel(tafel, _)

def bmi_qx(tafel: String, sex: String, groesse: Int, gewicht: Double): Int => Double = bmi_sterbetafel(tafel, sex, groesse, gewicht, _)

// Der Barwert kann dabei immer identisch definiert sein
def  barwert(zins: Int => Double, qx: Int => Double, spektrum: Int => Double) (von: Int, bis: Int, eintrittsAlter: Int): Double = {
    if ( von > bis)
        0.0;
    else 
        spektrum(von) + (1.0 - qx(von + eintrittsAlter)) * v(zins(von)) * barwert(zins, qx, spektrum)(von + 1, bis, sex, eintrittsAlter);
}
