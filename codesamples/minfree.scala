// Inspired by "Pearls of functional algorithm design" by Richard Bird, Cambridge University Press, Chapter 1

def minfree(list: List[Int]): Int = {
    Stream.from(1).dropWhile(list contains).head
}

def l1 = List(26, 9, 22, 3, 17, 13, 21, 25, 14, 15, 20, 7, 2, 24, 12, 8, 19, 11, 27, 6, 5, 23, 18, 1, 16, 4, 10)
minfree(l1)

def l2 = List(26, 9, 22, 3, 17, 13, 21, 25, 14, 15, 20, 7, 2, 24, 8, 19, 11, 27, 6, 5, 23, 18, 1, 16, 4, 10)
minfree(l2)
