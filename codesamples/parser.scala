// From chapter 19 of "Scala for the Impatient"

import scala.util.parsing.combinator._

class ExprParser extends RegexParsers {
    val number = "[0-9+]".r

    def expr: Parser[Any] = term ~ opt(("+" | "-") ~ expr)
    def term: Parser[Any] = factor ~ rep("*" ~ factor)
    def factor: Parser[Any] = number | "(" ~ expr ~ ")"
}

val parser = new ExprParser
val result = parser.parseAll(parser.expr, "3-4*5")
if (result.successful) println(result.get)

// ----------------------------------------

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

val evalParser = new EvalParser
parser.parseAll(evalParser.expr, "3-4*5")

// ----------------------------------------

class ParseTree
case class Number(value: Int) extends ParseTree
case class Operator(op: String, left: ParseTree, right: ParseTree) extends ParseTree

class TreeParser extends RegexParsers {
    val number = "[0-9+]".r

    def expr: Parser[ParseTree] = term ~ opt(("+" | "-") ~ expr) ^^ {
        case a ~ None => a
        case a ~ Some("+" ~ b) => Operator("+", a, b)
        case a ~ Some("-" ~ b) => Operator("-", a, b)
    }
    def term: Parser[ParseTree] = factor ~ opt("*" ~> term) ^^ {
        case a ~ None => a
        case a ~ Some(b) => Operator("*", a, b)
    }
    def factor: Parser[ParseTree] = number ^^ (n => Number(n.toInt)) | "(" ~> expr <~ ")"
}

val treeParser = new TreeParser
parser.parseAll(treeParser.expr, "3-4*5")

