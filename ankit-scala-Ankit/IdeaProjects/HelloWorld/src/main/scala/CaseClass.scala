case class CaseClass(a: Int, b: String)
object CaseClassTest extends App {
  val value1 = CaseClass(1, "a")
  val value2 = CaseClass(1, "a")
  val value3 = CaseClass(1, "b")


  if (value1 == value3) {
    println(value1 + " and " + value3 + " are same.")
  }
  else {
    println(value1 + " and " + value3 + " are different.")
  }

  if (value1 == value2) {
    println(value1 + " and " + value2 + " are same.")
  }
  else {
    println(value1 + " and " + value2 + " are different.")

  }

  if (value2 == value3) {
    println(value2 + " and " + value3 + " are same.")
  }
  else {
    println(value2 + " and " + value3 + " are different.")

  }

}