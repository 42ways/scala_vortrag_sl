// Quicksort einer Integer-Liste (rekursiv)

object quicksort {

  def quicksort(list: List[Int]): List[Int] = {
    println(list)
    list match {
      case Nil     => Nil
      case x :: xs => quicksort(xs.filter(_ <= x)) ++ List(x) ++ quicksort(xs.filter(_ > x))
    }
  }                                               //> quicksort: (list: List[Int])List[Int]

  def l = List(2, 18, 3, 1, 7, 10, 0, 9, 5, 4, 6) //> l: => List[Int]

  quicksort(l)                                    //> List(2, 18, 3, 1, 7, 10, 0, 9, 5, 4, 6)
                                                  //| List(1, 0)
                                                  //| List(0)
                                                  //| List()
                                                  //| List()
                                                  //| List()
                                                  //| List(18, 3, 7, 10, 9, 5, 4, 6)
                                                  //| List(3, 7, 10, 9, 5, 4, 6)
                                                  //| List()
                                                  //| List(7, 10, 9, 5, 4, 6)
                                                  //| List(5, 4, 6)
                                                  //| List(4)
                                                  //| List()
                                                  //| List()
                                                  //| List(6)
                                                  //| List()
                                                  //| List()
                                                  //| List(10, 9)
                                                  //| List(9)
                                                  //| List()
                                                  //| List()
                                                  //| List()
                                                  //| List()
                                                  //| res0: List[Int] = List(0, 1, 2, 3, 4, 5, 6, 7, 9, 10, 18)
}