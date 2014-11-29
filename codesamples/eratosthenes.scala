// Sieve of Eratosthenes
import scala.language.postfixOps

// Konzeptuell
// 1. Schreibe alle natürlichen Zahlen ab 2 hintereinander auf.
// 2. Die kleinste nicht gestrichene Zahl in dieser Folge ist eine Primzahl. Streiche alle Vielfachen dieser Zahl.
// 3. Wiederhole Schritt 2 mit der kleinsten noch nicht gestrichenen Zahl.

def sieve(natSeq: Stream[Int]): Stream[Int] =
        Stream.cons(natSeq.head,
                    sieve ((natSeq tail) filter (n => n % natSeq.head != 0)) )

def primes = sieve(Stream from 2)

def firstNprimes(n: Int) = primes take n toList

