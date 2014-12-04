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

	def fac(n: Int) = (1 to n) reduceLeft(_*_)//> fac: (n: Int)Int


	fac(5)                                    //> res5: Int = 120

	def squareSum(n: Int) = (1 to n) map(x => x*x ) reduceLeft(_+_)
                                                  //> squareSum: (n: Int)Int

	squareSum(1)                              //> res6: Int = 1
	squareSum(2)                              //> res7: Int = 5
	squareSum(3)                              //> res8: Int = 14
	squareSum(4)                              //> res9: Int = 30

}