// Beispiel: Vermoegensaufteilung

val b = Array(0, 1200, 1200, 1300, 1250, 1200, 1200, 1200)
val b_gef = Array(0, 600, 600, 720, 580, 610, 590, 600)

val z = 1.0125

def w(n:Int):Double = if (n<=0) 0 else w(n-1) * z + b(n)

def w_gef(n:Int):Double = if (n<=0) 0 else w(n) * (w_gef(n-1) + b_gef(n)) / (w(n-1) + b(n))

def W(n:Int):(Double, Double) = {
	if (n<=0) (0, 0)
    else {
        val (w_n_1, w_gef_n_1) = W(n-1)
        val w_n = w_n_1 * z + b(n)
        val w_gef_n = w_n * (w_gef_n_1 + b_gef(n)) / (w_n_1 + b(n))
        (w_n, w_gef_n)
    }
}

