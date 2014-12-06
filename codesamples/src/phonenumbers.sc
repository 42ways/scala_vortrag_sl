// Example from https://class.coursera.org/progfun-005/lecture/115
// Problem taken from Lutz Prechelt: An Empirical Comparison of Seven Programming Languages. IEEE Computer 33(10): 23-29 (2000)
// Tested with Tcl, Python, Perl, Rexx, Java, C++, C. Code size medians: 100 loc for scripting languages, 200-300 loc for the others

object phonenumbers {

  val in = scala.io.Source.fromURL(getClass.getResource("linuxwords.txt"))

  val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter))
	
  val mnem = Map('2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL",
    '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

  /** Invert the mnemonics map to give a map from chars 'A' ... 'Z' to '2' ... '9' */
  val charCode: Map[Char, Char] =
    for ((digit, str) <- mnem; letter <- str) yield (letter -> digit)

  /** Maps a word to the digit string it can represent */
 def wordCode(word: String): String = word.toUpperCase map charCode

  /**
   * A map from digit strings to the words that represent them,
   * e,g. “5282” -> Set(“Java”, “Kata”, “Lava”, ...)
   */
 val wordsForNum: Map[String, Seq[String]] =
    words groupBy wordCode withDefaultValue List()

  /** Return all ways to encode a number as a list of words */
  def encode(number: String): Set[List[String]] =
    if (number.isEmpty)
      Set(List())
    else {
      for {
        splitPoint <- 1 to number.length
        word <- wordsForNum(number take splitPoint)
        rest <- encode(number drop splitPoint)
      } yield word :: rest
    }.toSet

  /** Maps a number to a list of all word phrases that can represent it */
  def translate(number: String): Set[String] = encode(number) map (_ mkString " ")

  translate("7225247386")

}
