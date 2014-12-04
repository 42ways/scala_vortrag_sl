object lists {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(24); val res$0 = 
  1 to 10;System.out.println("""res0: scala.collection.immutable.Range.Inclusive = """ + $show(res$0));$skip(31); val res$1 = 

  1 to 10 filter (_ % 2 == 0);System.out.println("""res1: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$1));$skip(23); val res$2 = 

  1 to 10 map (_ * 2);System.out.println("""res2: scala.collection.immutable.IndexedSeq[Int] = """ + $show(res$2));$skip(28); val res$3 = 

  (1 to 10) zip (11 to 20);System.out.println("""res3: scala.collection.immutable.IndexedSeq[(Int, Int)] = """ + $show(res$3));$skip(53); val res$4 = 

  List("Peter", "Paul", "Mary") map (_.toUpperCase);System.out.println("""res4: List[String] = """ + $show(res$4));$skip(45); 

	def fac(n: Int) = (1 to n) reduceLeft(_*_);System.out.println("""fac: (n: Int)Int""");$skip(10); val res$5 = 


	fac(5);System.out.println("""res5: Int = """ + $show(res$5));$skip(66); 

	def squareSum(n: Int) = (1 to n) map(x => x*x ) reduceLeft(_+_);System.out.println("""squareSum: (n: Int)Int""");$skip(15); val res$6 = 

	squareSum(1);System.out.println("""res6: Int = """ + $show(res$6));$skip(14); val res$7 = 
	squareSum(2);System.out.println("""res7: Int = """ + $show(res$7));$skip(14); val res$8 = 
	squareSum(3);System.out.println("""res8: Int = """ + $show(res$8));$skip(14); val res$9 = 
	squareSum(4);System.out.println("""res9: Int = """ + $show(res$9))}

}
