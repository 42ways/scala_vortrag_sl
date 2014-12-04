// control abstractions (currying and call by name)

object until {

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  }                                               //> until: (condition: => Boolean)(block: => Unit)Unit

  var x = 10                                      //> x  : Int = 10
  until (x == 0) {
    x -= 1
    println(x)
  }                                               //> 9
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