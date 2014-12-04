// Towers of Hanoi

object hanoi {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(343); 

  def hanoi(n: Int): List[String] = {
    def move(a: String, b: String) = List(a + b)
    def _hanoi(n: Int, a: String, b: String, c: String): List[String] =
      if (n > 0)
        _hanoi(n - 1, a, c, b) ::: move(a, b) ::: _hanoi(n - 1, c, b, a)
      else
        List()
    _hanoi(n, "A", "B", "C")
  };System.out.println("""hanoi: (n: Int)List[String]""");$skip(12); val res$0 = 

  hanoi(2);System.out.println("""res0: List[String] = """ + $show(res$0))}

}
