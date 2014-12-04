import java.util.Date

case class Person(val sex: String, val groesse: Int, val gewicht: Double, val birthDate: Date) {
  def age(at: Date) = at.getYear - birthDate.getYear
}
