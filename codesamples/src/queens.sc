// n-queens from "Programming in Scala", p. 484 ff.

object queens {

  def queens(n: Int): Set[List[(Int, Int)]] = {
    def placeQueens(k: Int): Set[List[(Int, Int)]] =
      if (k == 0)
        Set(List())
      else
        for {
          queens <- placeQueens(k - 1)
          column <- 1 to n
          queen = (k, column)
          if isSafe(queen, queens)
        } yield queen :: queens

    def isSafe(queen: (Int, Int), queens: List[(Int, Int)]) =
      queens forall (q => !inCheck(queen, q))

    def inCheck(q1: (Int, Int), q2: (Int, Int)) =
      q1._1 == q2._1 || q1._2 == q2._2 || (q1._1 - q2._1).abs == (q1._2 - q2._2).abs

    placeQueens(n)
  }                                               //> queens: (n: Int)Set[List[(Int, Int)]]

  queens(10)                                      //> res0: Set[List[(Int, Int)]] = Set(List((10,3), (9,8), (8,6), (7,9), (6,2), (
                                                  //| 5,5), (4,1), (3,4), (2,7), (1,10)), List((10,5), (9,9), (8,2), (7,4), (6,8),
                                                  //|  (5,1), (4,3), (3,6), (2,10), (1,7)), List((10,9), (9,5), (8,8), (7,4), (6,1
                                                  //| ), (5,10), (4,2), (3,6), (2,3), (1,7)), List((10,4), (9,7), (8,5), (7,3), (6
                                                  //| ,1), (5,10), (4,8), (3,6), (2,9), (1,2)), List((10,7), (9,5), (8,1), (7,8), 
                                                  //| (6,10), (5,3), (4,6), (3,9), (2,2), (1,4)), List((10,4), (9,6), (8,1), (7,9)
                                                  //| , (6,7), (5,3), (4,8), (3,2), (2,5), (1,10)), List((10,10), (9,1), (8,6), (7
                                                  //| ,4), (6,2), (5,8), (4,3), (3,9), (2,7), (1,5)), List((10,9), (9,5), (8,2), (
                                                  //| 7,10), (6,3), (5,6), (4,8), (3,1), (2,4), (1,7)), List((10,7), (9,3), (8,6),
                                                  //|  (7,2), (6,10), (5,1), (4,4), (3,8), (2,5), (1,9)), List((10,7), (9,2), (8,6
                                                  //| ), (7,1), (6,10), (5,5), (4,3), (3,9), (2,4), (1,8)), List((10,10), (9,6), (
                                                  //| 8,3), (7,1), (6,4), (5,7), (4,9), (3,2), (2,5), (1,8)), List((10,1), (9,6), 
                                                  //| (8,8), (7,2), (6,7), (5,
                                                  //| Output exceeds cutoff limit.

}