// from "Scala for the Impatient, p. 153, Exercise 7"

object adjustToPair {

  def adjustToPair(f: (Int, Int) => Int)(p: (Int, Int)) = f(p._1, p._2)
                                                  //> adjustToPair: (f: (Int, Int) => Int)(p: (Int, Int))Int

  adjustToPair(_ * _)((6, 7))                     //> res0: Int = 42

  val pairs = (1 to 10) zip (11 to 20)            //> pairs  : scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,11), 
                                                  //| (2,12), (3,13), (4,14), (5,15), (6,16), (7,17), (8,18), (9,19), (10,20))

  pairs.map(adjustToPair(_ + _))                  //> res1: scala.collection.immutable.IndexedSeq[Int] = Vector(12, 14, 16, 18, 20
                                                  //| , 22, 24, 26, 28, 30)

}