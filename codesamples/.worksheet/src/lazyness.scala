// examples for lazy evaluation

object lazyness {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(166); 

//  val ones: Stream[Int] = Stream.cons(1, ones)

  def constant[A](n: A): Stream[A] = Stream.cons(n, constant(n));System.out.println("""constant: [A](n: A)Stream[A]""");$skip(35); val res$0 = 
  constant("Hello").take(5).toList;System.out.println("""res0: List[String] = """ + $show(res$0));$skip(63); 

  def from(n: Int): Stream[Int] = Stream.cons(n, from(n + 1));System.out.println("""from: (n: Int)Stream[Int]""");$skip(27); val res$1 = 
  from(42).take(42).toList;System.out.println("""res1: List[Int] = """ + $show(res$1));$skip(82); 

  def fibsFrom(a: Int, b: Int): Stream[Int] = Stream.cons(a, fibsFrom(b, a + b));System.out.println("""fibsFrom: (a: Int, b: Int)Stream[Int]""");$skip(28); 
  def fibs = fibsFrom(0, 1);System.out.println("""fibs: => Stream[Int]""");$skip(12); val res$2 = 

  fibs(10);System.out.println("""res2: Int = """ + $show(res$2));$skip(117); 

  val fibs2 = {
    def go(f0: Int, f1: Int): Stream[Int] =
      Stream.cons(f0, go(f1, f0 + f1))
    go(0, 1)
  };System.out.println("""fibs2  : Stream[Int] = """ + $show(fibs2 ));$skip(13); val res$3 = 

  fibs2(10);System.out.println("""res3: Int = """ + $show(res$3))}

}
