// extract algorithmic structures with higher order functions

object recschema {

  // some recursive functions

  def fac(n: Int): Int = {
    if (n == 0) 1
    else n * fac(n - 1)
  }

  def sumUpTo(n: Int): Int = {
    if (n == 0) 0
    else n + sumUpTo(n - 1)
  }

  def squareSumUpTo(n: Int): Int = {
    if (n == 0) 0
    else n * n + squareSumUpTo(n - 1)
  }

  // extract recursion pattern

  def myRecScheme(initval: Int, func: (Int, Int) => Int): Int => Int = {
    n =>
      if (n == 0) initval
      else func(n, myRecScheme(initval, func)(n - 1))
  }

  def fac2 = myRecScheme(1, _ * _)

  def sumUpTo2 = myRecScheme(0, _ + _)

  def squareSumUpTo2 = myRecScheme(0, (a, b) => a * a + b)

  // extract steps and end condition as well

  def mySecondRecScheme(terminate: Int => Boolean, step: Int => Int, initval: Int, func: (Int, Int) => Int): Int => Int = {
    n =>
      if (terminate(n)) initval
      else func(n, mySecondRecScheme(terminate, step, initval, func)(step(n)))
  }

  def fac3 = mySecondRecScheme(_ == 0, _ - 1, 1, _ * _)

}
