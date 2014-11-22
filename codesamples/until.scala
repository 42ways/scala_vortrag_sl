// control abstractions (currying and call by name)

def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
        block
        until(condition)(block)
    }
}

var x = 10
until (x == 0) {
    x -= 1
    println (x)
}

