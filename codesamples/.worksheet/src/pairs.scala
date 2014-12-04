object pairs {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(25); 
	val n = 7;System.out.println("""n  : Int = """ + $show(n ));$skip(109); val res$0 = 

	( 1 until n ) flatMap (i =>
		( 1 until i ) map (j => (i, j))) filter (pair => isPrime(pair._1 + pair._2));System.out.println("""res0: <error> = """ + $show(res$0))}
}
