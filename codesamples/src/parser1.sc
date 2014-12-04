// From chapter 19 of "Scala for the Impatient"

import scala.util.parsing.combinator.RegexParsers

class ExprParser extends RegexParsers {
  val number = "[0-9+]".r

  def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
  def term: Parser[Any] = factor ~ rep("*" ~ factor)
  def factor: Parser[Any] = number | "(" ~ expr ~ ")"
}

object expr_parser_test {
  val parser = new ExprParser                     //> parser  : ExprParser = ExprParser@180bc464
  val result = parser.parseAll(parser.expr, "3-4*5")
                                                  //> result  : expr_parser_test.parser.ParseResult[Any] = [1.6] parsed: ((3~List(
                                                  //| ))~Some((-~((4~List((*~5)))~None))))
  if (result.successful) println(result.get)      //> ((3~List())~Some((-~((4~List((*~5)))~None))))
}