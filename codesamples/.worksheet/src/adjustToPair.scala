// from "Scala for the Impatient, p. 153, Exercise 7"

object adjustToPair {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(149); 

  def adjustToPair(f: (Int, Int) => Int)(p: (Int, Int)) = f(p._1, p._2);System.out.println("""adjustToPair: (f: (Int, Int) => Int)(p: (Int, Int))Int""");$skip(31); val res$0 = 

  adjustToPair(_ * _)((6, 7));System.out.println("""res0: Int = """ + $show(res$0));$skip(40); 

  val pairs = (1 to 10) zip (11 to 20);System.out.println("""pairs  : scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(pairs ));$skip(34); val res$1 = 

  pairs.map(adjustToPair(_ + _));System.out.println("""res1: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$1))}

}
