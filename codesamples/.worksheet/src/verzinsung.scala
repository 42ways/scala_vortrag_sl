object verzinsung {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(144); 

  // Diskontierung mit Zinssatz als Parameter
  def diskontiere(zinsSatz: Double, wert: Double) = wert * 1 / (1 + zinsSatz);System.out.println("""diskontiere: (zinsSatz: Double, wert: Double)Double""");$skip(110); 

  // Diskontierung mit festgelegten Zinssätzen
  def diskont_0175: Double => Double = diskontiere(0.0175, _);System.out.println("""diskont_0175: => Double => Double""");$skip(62); 
  def diskont_0125: Double => Double = diskontiere(0.0125, _);System.out.println("""diskont_0125: => Double => Double""")}

}
