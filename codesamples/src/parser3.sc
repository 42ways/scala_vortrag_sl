// From chapter 19 of "Scala for the Impatient"

import scala.util.parsing.combinator.RegexParsers

class TreeParser extends RegexParsers {
  class ParseTree
  case class Number(value: Int) extends ParseTree
  case class Operator(op: String, left: ParseTree, right: ParseTree) extends ParseTree

  val number = "[0-9+]".r

  def expr: Parser[ParseTree] = term ~ opt(("+" | "-") ~ expr) ^^ {
    case a ~ None          => a
    case a ~ Some("+" ~ b) => Operator("+", a, b)
    case a ~ Some("-" ~ b) => Operator("-", a, b)
  }
  def term: Parser[ParseTree] = factor ~ opt("*" ~> term) ^^ {
    case a ~ None    => a
    case a ~ Some(b) => Operator("*", a, b)
  }
  def factor: Parser[ParseTree] = number ^^ (n => Number(n.toInt)) | "(" ~> expr <~ ")"
}

object tree_parser_test {
  val parser = new TreeParser                     //> parser  : TreeParser = TreeParser@180bc464
  val result = parser.parseAll(parser.expr, "3-4*5")
                                                  //> result  : tree_parser_test.parser.ParseResult[tree_parser_test.parser.ParseT
                                                  //| ree] = [1.6] parsed: Operator(-,Number(3),Operator(*,Number(4),Number(5)))
  if (result.successful) println(result.get)      //> Operator(-,Number(3),Operator(*,Number(4),Number(5)))
}