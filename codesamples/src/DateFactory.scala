import java.util.Calendar

object DateFactory {
  def apply(year: Int, month: Int = 1, date: Int = 1) = {
    val cal = Calendar.getInstance()
    cal.set(year, month, date)
    cal.getTime
  }
}
