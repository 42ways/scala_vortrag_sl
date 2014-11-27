// Quicksort einer Integer-Liste (rekursiv)

def quicksort(l: List[Int]): List[Int] = {
    l match {
        case Nil => Nil
        case x :: xs => quicksort(xs.filter(_ <= x)) ++ List(x) ++ quicksort(xs.filter(_ > x))
    }
}

def list = List(2,8,3,1,7,0,9,5,4,6)
quicksort(list)
