// Beispiel: Vermoegensaufteilung

class Vermoegensaufteilung(b:Array[Double], b_gef:Array[Double], growth: Double => Double) {

    def w(n:Int):Double = if (n<=0) 0 else growth(w(n-1)) + b(n)

    def w_gef(n:Int):Double = if (n<=0) 0 else w(n) * (w_gef(n-1) + b_gef(n)) / (w(n-1) + b(n))

    def W(n:Int):(Double, Double) = {
    	if (n<=0) (0, 0)
        else {
            val (w_n_1, w_gef_n_1) = W(n-1)
            val w_n = growth(w_n_1) + b(n)
            val w_gef_n = w_n * (w_gef_n_1 + b_gef(n)) / (w_n_1 + b(n))
            (w_n, w_gef_n)
        }
    }
}

val b = Array(0.0, 1200, 1200, 1300, 1250, 1200, 1200, 1200)
val b_gef = Array(0.0, 600, 600, 720, 580, 610, 590, 600)

def g1(interest:Double)(value:Double) = value * (1 + interest / 100)

val v1 = new Vermoegensaufteilung(b, b_gef, g1(1.25))
val v2 = new Vermoegensaufteilung(b, b_gef, g1(1.75))

def g2(interest:Double, fixcharge: Double)(value:Double) = value * (1 + interest / 100) - fixcharge

val v3 = new Vermoegensaufteilung(b, b_gef, g2(1.25, 10.0))
val v4 = new Vermoegensaufteilung(b, b_gef, g2(1.75, 10.0))

List(v1, v2, v3, v4).map(_.W(5))
