// higher order functions, currying and composition

object higher_functions {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(152); 

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    b => f(a, b);System.out.println("""partial1: [A, B, C](a: A, f: (A, B) => C)B => C""");$skip(77); 

  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b);System.out.println("""curry: [A, B, C](f: (A, B) => C)A => (B => C)""");$skip(77); 

  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b);System.out.println("""uncurry: [A, B, C](f: A => (B => C))(A, B) => C""");$skip(73); 

  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a));System.out.println("""compose: [A, B, C](f: B => C, g: A => B)A => C""");$skip(31); 

  def f1(n: Int): Int = n * 2;System.out.println("""f1: (n: Int)Int""");$skip(29); 
  def f2(n: Int):Int = n + 1;System.out.println("""f2: (n: Int)Int""");$skip(26); 
  val f = compose(f1, f2);System.out.println("""f  : Int => Int = """ + $show(f ));$skip(7); val res$0 = 
  f(5);System.out.println("""res0: Int = """ + $show(res$0))}
}
