// extract algorithmic structures with higher order functions

object recschema {

  // some recursive functions

  def fac(n: Int): Int = {
    if (n == 0) 1
    else n * fac(n - 1)
  }                                               //> fac: (n: Int)Int

  def sumUpTo(n: Int): Int = {
    if (n == 0) 0
    else n + sumUpTo(n - 1)
  }                                               //> sumUpTo: (n: Int)Int

  def squareSumUpTo(n: Int): Int = {
    if (n == 0) 0
    else n * n + squareSumUpTo(n - 1)
  }                                               //> squareSumUpTo: (n: Int)Int

  // extract recursion pattern

  def myRecScheme(initval: Int, func: (Int, Int) => Int): Int => Int = {
    n =>
      if (n == 0) initval
      else func(n, myRecScheme(initval, func)(n - 1))
  }                                               //> myRecScheme: (initval: Int, func: (Int, Int) => Int)Int => Int

  def fac2 = myRecScheme(1, _ * _)                //> fac2: => Int => Int

  def sumUpTo2 = myRecScheme(0, _ + _)            //> sumUpTo2: => Int => Int

  def squareSumUpTo2 = myRecScheme(0, (a, b) => a * a + b)
                                                  //> squareSumUpTo2: => Int => Int

  // extract steps and end condition as well

  def mySecondRecScheme(terminate: Int => Boolean, step: Int => Int, initval: Int, func: (Int, Int) => Int): Int => Int = {
    n =>
      if (terminate(n)) initval
      else func(n, mySecondRecScheme(terminate, step, initval, func)(step(n)))
  }                                               //> mySecondRecScheme: (terminate: Int => Boolean, step: Int => Int, initval: In
                                                  //| t, func: (Int, Int) => Int)Int => Int

  def fac3 = mySecondRecScheme(_ == 0, _ - 1, 1, _ * _)
                                                  //> fac3: => Int => Int

}