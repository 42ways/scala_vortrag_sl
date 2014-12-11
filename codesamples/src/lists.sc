object lists {
  1 to 10                                         //> res0: scala.collection.immutable.Range.Inclusive = Range(1, 2, 3, 4, 5, 6, 7,
                                                  //|  8, 9, 10)

  1 to 10 filter (_ % 2 == 0)                     //> res1: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10)

  1 to 10 map (_ * 2)                             //> res2: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 4, 6, 8, 10, 12,
                                                  //|  14, 16, 18, 20)

  (1 to 10) zip (11 to 20)                        //> res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((1,11), (2,
                                                  //| 12), (3,13), (4,14), (5,15), (6,16), (7,17), (8,18), (9,19), (10,20))

  List("Peter", "Paul", "Mary") map (_.toUpperCase)
                                                  //> res4: List[String] = List(PETER, PAUL, MARY)

	def fac(n: Int) = (1 to n) reduce(_*_)    //> fac: (n: Int)Int


	fac(5)                                    //> res5: Int = 120

  fac(0)                                          //> java.lang.UnsupportedOperationException: empty.reduceLeft
                                                  //| 	at scala.collection.TraversableOnce$class.reduceLeft(TraversableOnce.sca
                                                  //| la:165)
                                                  //| 	at scala.collection.AbstractTraversable.reduceLeft(Traversable.scala:104
                                                  //| )
                                                  //| 	at scala.collection.TraversableOnce$class.reduce(TraversableOnce.scala:1
                                                  //| 93)
                                                  //| 	at scala.collection.AbstractTraversable.reduce(Traversable.scala:104)
                                                  //| 	at lists$$anonfun$main$1.fac$1(lists.scala:12)
                                                  //| 	at lists$$anonfun$main$1.apply$mcV$sp(lists.scala:17)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$$anonfun$$exe
                                                  //| cute$1.apply$mcV$sp(WorksheetSupport.scala:76)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.redirected(W
                                                  //| orksheetSupport.scala:65)
                                                  //| 	at org.scalaide.worksheet.runtime.library.WorksheetSupport$.$execute(Wor
                                                  //| ksheetSupport.scala:75)
                                                  //| 	at lists$.main(lists.scala:1)
                                                  //| 	at lists.main(lists.scala)
  
	def squareSum(n: Int) = (1 to n) map(x => x*x ) reduce(_+_)

	squareSum(1)
	squareSum(2)
	squareSum(3)
	squareSum(4)

}