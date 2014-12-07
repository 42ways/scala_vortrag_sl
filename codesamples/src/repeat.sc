// Exercise from https://class.coursera.org/reactive-001/lecture/35

object repeat {

  class repeat(commands: => Unit) {
    def until(condition: => Boolean): Unit = {
        commands
      if (condition) ()
      else until(condition)
    }
  }
  object repeat {
    def apply(commands: => Unit) = new repeat(commands)
  }

  var x = 10                                      //> x  : Int = 10
  repeat {
    x -= 1
    println(x)
  } until (x <= 0)                                //> 9
                                                  //| 8
                                                  //| 7
                                                  //| 6
                                                  //| 5
                                                  //| 4
                                                  //| 3
                                                  //| 2
                                                  //| 1
                                                  //| 0

}