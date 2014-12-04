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

object Vermoegensaufteilung {

  val b = Array(0.0, 1200, 1200, 1300, 1250, 1200, 1200, 1200)
                                                  //> b  : Array[Double] = Array(0.0, 1200.0, 1200.0, 1300.0, 1250.0, 1200.0, 1200
                                                  //| .0, 1200.0)
  val b_gef = Array(0.0, 600, 600, 720, 580, 610, 590, 600)
                                                  //> b_gef  : Array[Double] = Array(0.0, 600.0, 600.0, 720.0, 580.0, 610.0, 590.0
                                                  //| , 600.0)

  def g1(interest: Double)(value: Double) = value * (1 + interest / 100)
                                                  //> g1: (interest: Double)(value: Double)Double

  val v1 = new Vermoegensaufteilung(b, b_gef, g1(1.25))
                                                  //> v1  : Vermoegensaufteilung = Vermoegensaufteilung@5315b42e
	v1.W(6)                                   //> res0: (Double, Double) = (7583.840215209961,3818.364922221779)

  val v2 = new Vermoegensaufteilung(b, b_gef, g1(1.75))
                                                  //> v2  : Vermoegensaufteilung = Vermoegensaufteilung@6a024a67
	v2.W(6)                                   //> res1: (Double, Double) = (7679.5548694383215,3866.817260984521)


  def g2(interest: Double, fixcharge: Double)(value: Double) = value * (1 + interest / 100) - fixcharge
                                                  //> g2: (interest: Double, fixcharge: Double)(value: Double)Double

  val v3 = new Vermoegensaufteilung(b, b_gef, g2(1.25, 10.0))
                                                  //> v3  : Vermoegensaufteilung = Vermoegensaufteilung@7921b0a2
	v3.W(6)                                   //> res2: (Double, Double) = (7521.933670773315,3787.068500478078)

  val v4 = new Vermoegensaufteilung(b, b_gef, g2(1.75, 10.0))
                                                  //> v4  : Vermoegensaufteilung = Vermoegensaufteilung@174d20a
	v4.W(6)                                   //> res3: (Double, Double) = (7616.867809888314,3835.1257775838976)

  List(v1, v2, v3, v4).map(_.W(5))                //> res4: List[(Double, Double)] = List((6305.027373046875,3188.683681135953), 
                                                  //| (6368.112893796876,3220.703884319491), (6253.761650146484,3162.745928220768
                                                  //| ), (6316.331999890234,3194.5055638533454))
}