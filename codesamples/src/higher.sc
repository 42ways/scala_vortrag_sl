// higher order functions, currying and composition

object higher_functions {

  def partial1[A, B, C](a: A, f: (A, B) => C): B => C =
    b => f(a, b)                                  //> partial1: [A, B, C](a: A, f: (A, B) => C)B => C

  def curry[A, B, C](f: (A, B) => C): A => (B => C) =
    a => b => f(a, b)                             //> curry: [A, B, C](f: (A, B) => C)A => (B => C)

  def uncurry[A, B, C](f: A => B => C): (A, B) => C =
    (a, b) => f(a)(b)                             //> uncurry: [A, B, C](f: A => (B => C))(A, B) => C

  def compose[A, B, C](f: B => C, g: A => B): A => C =
    a => f(g(a))                                  //> compose: [A, B, C](f: B => C, g: A => B)A => C

  def f1(n: Int): Int = n * 2                     //> f1: (n: Int)Int
  def f2(n: Int):Int = n + 1                      //> f2: (n: Int)Int
  val f = compose(f1, f2)                         //> f  : Int => Int = <function1>
  f(5)                                            //> res0: Int = 12
}