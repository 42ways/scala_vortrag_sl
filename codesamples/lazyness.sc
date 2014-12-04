// examples for lazy evaluation

object lazyness {

//  val ones: Stream[Int] = Stream.cons(1, ones)

  def constant[A](n: A): Stream[A] = Stream.cons(n, constant(n))
                                                  //> constant: [A](n: A)Stream[A]
  constant("Hello").take(5).toList                //> res0: List[String] = List(Hello, Hello, Hello, Hello, Hello)

  def from(n: Int): Stream[Int] = Stream.cons(n, from(n + 1))
                                                  //> from: (n: Int)Stream[Int]
  from(42).take(42).toList                        //> res1: List[Int] = List(42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 5
                                                  //| 5, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 7
                                                  //| 4, 75, 76, 77, 78, 79, 80, 81, 82, 83)

  def fibsFrom(a: Int, b: Int): Stream[Int] = Stream.cons(a, fibsFrom(b, a + b))
                                                  //> fibsFrom: (a: Int, b: Int)Stream[Int]
  def fibs = fibsFrom(0, 1)                       //> fibs: => Stream[Int]

  fibs(10)                                        //> res2: Int = 55

  val fibs2 = {
    def go(f0: Int, f1: Int): Stream[Int] =
      Stream.cons(f0, go(f1, f0 + f1))
    go(0, 1)
  }                                               //> fibs2  : Stream[Int] = Stream(0, ?)

  fibs2(10)                                       //> res3: Int = 55

}