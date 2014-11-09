// examples for lazy evaluation

val ones: Stream[Int] = Stream.cons(1, ones)

def constant[A](n: A): Stream[A] = Stream.cons(n, constant(n))
constant("Hello").take(5).toList

def from(n: Int): Stream[Int] = Stream.cons(n, from(n+1))
from(42).take(42).toList

def fibsFrom(a: Int, b: Int): Stream[Int] = Stream.cons(a, fibsFrom(b, a + b))
def fibs = fibsFrom(0, 1)

val fibs = {
    def go(f0: Int, f1: Int): Stream[Int] = 
      Stream.cons(f0, go(f1, f0+f1))
    go(0, 1)
  }
