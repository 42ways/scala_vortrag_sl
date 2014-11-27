// extract algorithmic structures with higher order functions

def fac(n: Int): Int = {
    if (n == 0) 1
    else n * fac(n-1)
}

def sumUpTo(n: Int): Int = {
    if (n == 0) 0
    else n + sumUpTo(n-1)
}

def squareSumUpTo(n: Int): Int = {
    if (n == 0) 0
    else n * n + squareSumUpTo(n-1)
}

def simpleRecScheme(base: Int, op: (Int, Int) => Int)(n: Int): Int = {
    if (n == 0) base
    else op(n, simpleRecScheme(base, op)(n-1))
}

def fac2 = simpleRecScheme(1, (a, b) => a * b)_

def sumUpTo2 = simpleRecScheme(0, _ + _)_

def squareSumUpTo2 = simpleRecScheme(0, (a, b) => a * a + b)_

