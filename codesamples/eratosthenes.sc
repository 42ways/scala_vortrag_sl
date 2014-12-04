// Sieve of Eratosthenes
import scala.language.postfixOps

object eratosthenes {

  // Konzeptionell:
  // 1. Schreibe alle natürlichen Zahlen ab 2 hintereinander auf.
  // 2. Die kleinste nicht gestrichene Zahl in dieser Folge ist eine Primzahl. Streiche alle Vielfachen dieser Zahl.
  // 3. Wiederhole Schritt 2 mit der kleinsten noch nicht gestrichenen Zahl.

  def sieve(natSeq: Stream[Int]): Stream[Int] =
    Stream.cons(natSeq.head,
                sieve((natSeq tail) filter (n => n % natSeq.head != 0)))
                                                  //> sieve: (natSeq: Stream[Int])Stream[Int]

  def primes = sieve(Stream from 2)               //> primes: => Stream[Int]

	primes(4)                                 //> res0: Int = 11

  def firstNprimes(n: Int) = primes take n toList //> firstNprimes: (n: Int)List[Int]

  firstNprimes(10)                                //> res1: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29)
}