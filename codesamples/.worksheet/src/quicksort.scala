// Quicksort einer Integer-Liste (rekursiv)

object quicksort {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(258); 

  def quicksort(list: List[Int]): List[Int] = {
    list match {
      case Nil     => Nil
      case x :: xs => quicksort(xs.filter(_ <= x)) ++ List(x) ++ quicksort(xs.filter(_ > x))
    }
  };System.out.println("""quicksort: (list: List[Int])List[Int]""");$skip(50); 

  def l = List(2, 8, 3, 1, 7, 10, 0, 9, 5, 4, 6);System.out.println("""l: => List[Int]""");$skip(16); val res$0 = 

  quicksort(l);System.out.println("""res0: List[Int] = """ + $show(res$0))}
}
