// Inspired by "Pearls of functional algorithm design" by Richard Bird, Cambridge University Press, Chapter 1

object minfree {

  def minfree(list: List[Int]): Int = {
    Stream.from(1).dropWhile(list contains).head
  }                                               //> minfree: (list: List[Int])Int


  def l1 = List(26, 9, 22, 3, 17, 13, 21, 25, 14, 15, 20, 7, 2, 24, 12, 8, 19, 11, 27, 6, 5, 23, 18, 1, 16, 4, 10)
                                                  //> l1: => List[Int]
  minfree(l1)                                     //> res0: Int = 28


  def l2 = List(26, 9, 22, 3, 17, 13, 21, 25, 14, 15, 20, 7, 2, 24, 8, 19, 11, 27, 6, 5, 23, 18, 1, 16, 4, 10)
                                                  //> l2: => List[Int]
  minfree(l2)                                     //> res1: Int = 12
}