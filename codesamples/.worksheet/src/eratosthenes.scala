// Sieve of Eratosthenes
import scala.language.postfixOps

object eratosthenes {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(512); 

  // Konzeptionell:
  // 1. Schreibe alle natürlichen Zahlen ab 2 hintereinander auf.
  // 2. Die kleinste nicht gestrichene Zahl in dieser Folge ist eine Primzahl. Streiche alle Vielfachen dieser Zahl.
  // 3. Wiederhole Schritt 2 mit der kleinsten noch nicht gestrichenen Zahl.

  def sieve(natSeq: Stream[Int]): Stream[Int] =
    Stream.cons(natSeq.head,
                sieve((natSeq tail) filter (n => n % natSeq.head != 0)));System.out.println("""sieve: (natSeq: Stream[Int])Stream[Int]""");$skip(37); 

  def primes = sieve(Stream from 2);System.out.println("""primes: => Stream[Int]""");$skip(12); val res$0 = 

	primes(4);System.out.println("""res0: Int = """ + $show(res$0));$skip(51); 

  def firstNprimes(n: Int) = primes take n toList;System.out.println("""firstNprimes: (n: Int)List[Int]""");$skip(20); val res$1 = 

  firstNprimes(10);System.out.println("""res1: List[Int] = """ + $show(res$1))}
}
