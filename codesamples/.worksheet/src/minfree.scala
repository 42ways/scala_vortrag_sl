// Inspired by "Pearls of functional algorithm design" by Richard Bird, Cambridge University Press, Chapter 1

object minfree {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(221); 

  def minfree(list: List[Int]): Int = {
    Stream.from(1).dropWhile(list contains).head
  };System.out.println("""minfree: (list: List[Int])Int""");$skip(117); 


  def l1 = List(26, 9, 22, 3, 17, 13, 21, 25, 14, 15, 20, 7, 2, 24, 12, 8, 19, 11, 27, 6, 5, 23, 18, 1, 16, 4, 10);System.out.println("""l1: => List[Int]""");$skip(14); val res$0 = 
  minfree(l1);System.out.println("""res0: Int = """ + $show(res$0));$skip(113); 


  def l2 = List(26, 9, 22, 3, 17, 13, 21, 25, 14, 15, 20, 7, 2, 24, 8, 19, 11, 27, 6, 5, 23, 18, 1, 16, 4, 10);System.out.println("""l2: => List[Int]""");$skip(14); val res$1 = 
  minfree(l2);System.out.println("""res1: Int = """ + $show(res$1))}
}
