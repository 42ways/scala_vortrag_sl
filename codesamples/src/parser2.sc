// From chapter 19 of "Scala for the Impatient"

import scala.util.parsing.combinator.RegexParsers

class EvalParser extends RegexParsers {
    val number = "[0-9+]".r

    def expr: Parser[Int] = term ~ opt(("+" | "-") ~ expr) ^^ {
        case t ~ None => t
        case t ~ Some("+" ~ e) => t + e
        case t ~ Some("-" ~ e) => t - e
    }
    def term = factor ~ rep("*" ~> factor) ^^ {
        case f ~ r => f * r.product
    }
    def factor = number ^^ {_.toInt} | "(" ~> expr <~ ")"
}

object eval_parser_test {
  val parser = new EvalParser                     //> parser  : EvalParser = EvalParser@180bc464
  val result = parser.parseAll(parser.expr, "3-4*5")
                                                  //> result  : eval_parser_test.parser.ParseResult[Int] = [1.6] parsed: -17
  if (result.successful) println(result.get)      //> -17
}