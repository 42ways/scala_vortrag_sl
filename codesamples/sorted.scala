// example for type parameters

def isSorted[A] (as: Array[A], ordered: (A, A) => Boolean): Boolean = {
    def loop(n: Int): Boolean =
        if (n >= as.length - 1) true
        else if (! ordered(as(n), as(n+1))) false
        else loop(n+1)

    if (as.length < 2) true
    else loop(0)
}

isSorted(Array(1,3,5,7,9), (a:Int, b:Int) => a < b)  // true
isSorted(Array(1,3,7,5,9), (a:Int, b:Int) => a < b)  // false
isSorted(Array(1,3,3,5,9), (a:Int, b:Int) => a < b)  // false
isSorted(Array(1,3,3,5,9), (a:Int, b:Int) => a <= b)  // true
