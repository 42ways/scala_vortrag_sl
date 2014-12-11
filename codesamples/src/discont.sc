object discont {

  // Diskontierung mit Zinssatz als Parameter
  def diskont(zinsSatz: Double, wert: Double) = wert * 1 / (1 + zinsSatz)
                                                  //> diskont: (zinsSatz: Double, wert: Double)Double

	diskont(0.0175, 101.75)                   //> res0: Double = 100.0

  // Diskontierung mit festgelegten Zinssätzen
  def diskont_0175: Double => Double = diskont(0.0175, _)
                                                  //> diskont_0175: => Double => Double
  def diskont_0125: Double => Double = diskont(0.0125, _)
                                                  //> diskont_0125: => Double => Double

	diskont_0125(101.25)                      //> res1: Double = 100.0

 def diskont_x: Double => Double = diskont(_, 200.0)
                                                  //> diskont_x: => Double => Double

  diskont_x(0.1)                                  //> res2: Double = 181.8181818181818
}