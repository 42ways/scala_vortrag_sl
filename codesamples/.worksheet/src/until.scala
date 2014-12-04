// control abstractions (currying and call by name)

object until {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(195); 

  def until(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      until(condition)(block)
    }
  };System.out.println("""until: (condition: => Boolean)(block: => Unit)Unit""");$skip(14); 

  var x = 10;System.out.println("""x  : Int = """ + $show(x ));$skip(48); 
  until(x == 0) {
    x -= 1
    println(x)
  }}

}
