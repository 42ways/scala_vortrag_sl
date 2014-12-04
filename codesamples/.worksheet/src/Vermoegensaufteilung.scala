// Beispiel: Vermoegensaufteilung

class Vermoegensaufteilung(b: Array[Double], b_gef: Array[Double], growth: Double => Double) {

  def w(n: Int): Double = if (n <= 0) 0 else growth(w(n - 1)) + b(n)

  def w_gef(n: Int): Double = if (n <= 0) 0 else w(n) * (w_gef(n - 1) + b_gef(n)) / (w(n - 1) + b(n))

  def W(n: Int): (Double, Double) = {
    if (n <= 0) (0, 0)
    else {
      val (w_n_1, w_gef_n_1) = W(n - 1)
      val w_n = growth(w_n_1) + b(n)
      val w_gef_n = w_n * (w_gef_n_1 + b_gef(n)) / (w_n_1 + b(n))
      (w_n, w_gef_n)
    }
  }
}

object Vermoegensaufteilung {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(646); 

  val b = Array(0.0, 1200, 1200, 1300, 1250, 1200, 1200, 1200);System.out.println("""b  : Array[Double] = """ + $show(b ));$skip(60); 
  val b_gef = Array(0.0, 600, 600, 720, 580, 610, 590, 600);System.out.println("""b_gef  : Array[Double] = """ + $show(b_gef ));$skip(74); 

  def g1(interest: Double)(value: Double) = value * (1 + interest / 100);System.out.println("""g1: (interest: Double)(value: Double)Double""");$skip(57); 

  val v1 = new Vermoegensaufteilung(b, b_gef, g1(1.25));System.out.println("""v1  : Vermoegensaufteilung = """ + $show(v1 ));$skip(9); val res$0 = 
	v1.W(6);System.out.println("""res0: (Double, Double) = """ + $show(res$0));$skip(57); 

  val v2 = new Vermoegensaufteilung(b, b_gef, g1(1.75));System.out.println("""v2  : Vermoegensaufteilung = """ + $show(v2 ));$skip(9); val res$1 = 
	v2.W(6);System.out.println("""res1: (Double, Double) = """ + $show(res$1));$skip(106); 


  def g2(interest: Double, fixcharge: Double)(value: Double) = value * (1 + interest / 100) - fixcharge;System.out.println("""g2: (interest: Double, fixcharge: Double)(value: Double)Double""");$skip(63); 

  val v3 = new Vermoegensaufteilung(b, b_gef, g2(1.25, 10.0));System.out.println("""v3  : Vermoegensaufteilung = """ + $show(v3 ));$skip(9); val res$2 = 
	v3.W(6);System.out.println("""res2: (Double, Double) = """ + $show(res$2));$skip(63); 

  val v4 = new Vermoegensaufteilung(b, b_gef, g2(1.75, 10.0));System.out.println("""v4  : Vermoegensaufteilung = """ + $show(v4 ));$skip(9); val res$3 = 
	v4.W(6);System.out.println("""res3: (Double, Double) = """ + $show(res$3));$skip(36); val res$4 = 

  List(v1, v2, v3, v4).map(_.W(5));System.out.println("""res4: List[(Double, Double)] = """ + $show(res$4))}
}
