// Towers of Hanoi

object hanoi {

  def hanoi(n: Int): List[String] = {
    def move(a: String, b: String) = List(a + b)
    def _hanoi(n: Int, a: String, b: String, c: String): List[String] =
      if (n > 0)
        _hanoi(n - 1, a, c, b) ::: move(a, b) ::: _hanoi(n - 1, c, b, a)
      else
        List()
    _hanoi(n, "A", "B", "C")
  }                                               //> hanoi: (n: Int)List[String]

  hanoi(2)                                        //> res0: List[String] = List(AC, AB, CB)

}