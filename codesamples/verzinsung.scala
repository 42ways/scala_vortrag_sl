
// Diskontierung mit Zinssatz als Parameter
def diskontiere(zinsSatz: Double, wert: Double) = wert * 1 / (1 + zinsSatz)

// Diskontierung mit festgelegten Zinssätzen
def diskont_0175: Double => Double = diskontiere(0.0175, _)
def diskont_0125: Double => Double = diskontiere(0.0125, _)
