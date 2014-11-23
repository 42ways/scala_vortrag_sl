// From "Scala for the impatient", p. 241, Exercise 1

class Pair[T, S](val first: T, val second: S) {
    def swap = new Pair[S, T](second, first)
}

val p = new Pair("Test", 42)

p.swap
