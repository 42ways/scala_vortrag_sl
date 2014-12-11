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

	primes(5)                                 //> res0: Int = 13

  def firstNprimes(n: Int) = primes take n toList //> firstNprimes: (n: Int)List[Int]

  firstNprimes(100)                               //> res1: List[Int] = List(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 4
                                                  //| 7, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131
                                                  //| , 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211,
                                                  //|  223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 
                                                  //| 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 3
                                                  //| 97, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457, 461, 463, 467, 479, 48
                                                  //| 7, 491, 499, 503, 509, 521, 523, 541)
}