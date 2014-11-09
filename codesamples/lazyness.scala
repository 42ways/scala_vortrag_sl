// examples for lazy evaluation

val ones: Stream[Int] = Stream.cons(1, ones)

def constant[A](n: A): Stream[A] = Stream.cons(n, constant(n))
constant("Hello").take(5).toList

def from(n: Int): Stream[Int] = Stream.cons(n, from(n+1))
from(42).take(42).toList
