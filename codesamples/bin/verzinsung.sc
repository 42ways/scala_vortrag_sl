object verzinsung {

  // Diskontierung mit Zinssatz als Parameter
  def diskontiere(zinsSatz: Double, wert: Double) = wert * 1 / (1 + zinsSatz)
                                                  //> diskontiere: (zinsSatz: Double, wert: Double)Double

  // Diskontierung mit festgelegten Zinssätzen
  def diskont_0175: Double => Double = diskontiere(0.0175, _)
                                                  //> diskont_0175: => Double => Double
  def diskont_0125: Double => Double = diskontiere(0.0125, _)
                                                  //> diskont_0125: => Double => Double
                                                  	
}