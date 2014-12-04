// Quicksort einer Integer-Liste (rekursiv)

object quicksort {

  def quicksort(list: List[Int]): List[Int] = {
    list match {
      case Nil     => Nil
      case x :: xs => quicksort(xs.filter(_ <= x)) ++ List(x) ++ quicksort(xs.filter(_ > x))
    }
  }                                               //> quicksort: (list: List[Int])List[Int]

  def l = List(2, 8, 3, 1, 7, 10, 0, 9, 5, 4, 6)  //> l: => List[Int]

  quicksort(l)                                    //> res0: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
}