// partially applied functions (currying)

object CurryTest {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(228); 

  def filter(xs: List[Int], p: Int => Boolean): List[Int] =
    if (xs.isEmpty) xs
    else if (p(xs.head)) xs.head :: filter(xs.tail, p)
    else filter(xs.tail, p);System.out.println("""filter: (xs: List[Int], p: Int => Boolean)List[Int]""");$skip(45); 

  def modN(n: Int)(x: Int) = ((x % n) == 0);System.out.println("""modN: (n: Int)(x: Int)Boolean""");$skip(43); 

  val nums = List(1, 2, 3, 4, 5, 6, 7, 8);System.out.println("""nums  : List[Int] = """ + $show(nums ));$skip(34); 

  println(filter(nums, modN(2)));$skip(33); 
  println(filter(nums, modN(3)));$skip(21); 

  val m4 = modN(4)_;System.out.println("""m4  : Int => Boolean = """ + $show(m4 ));$skip(28); 
  println(filter(nums, m4))}
}
