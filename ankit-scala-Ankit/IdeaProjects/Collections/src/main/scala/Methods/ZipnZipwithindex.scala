package Methods

object ZipnZipwithindex extends App {
  println("Printing with ZipWithIndex method:")

  val days = List("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
  days.zipWithIndex.foreach{
    case(day, count) => println(s"$day is at $count" + "th  position")
  }
println("\nPrinting with zip method")
  for ((hello, world) <- days.zip(Stream from 1)){
    println(hello + " is at " + world + " position")
  }
  //val typecheck = days.zip(Stream from 1)



  println("\n\n")
  val nums = Seq(1,2,3)
  val letters = Array('a', 'b', 'c')
  val res = for {

    n <- nums
    c <- letters
  } yield (c, n)

  //tuple is a miscellaneous collection of element.
  val stuff:(String , String, String) = ("7465837445", "Ankit", "Sharma") //  initializing tuples.
  stuff.getClass
  println(stuff._2) //accessing tuple element.
  println(stuff._3)
  println(stuff._1)
  val(x, y, z)= stuff //use variable name to access tuple elements.

  val(a, _, _) = stuff //accessing only some elements

  def sum(ints: List[Int]):Int= ints match {
    case Nil => 0
    case x :: ankit => x + sum(ankit)
  }
  val list= List.range(1,16)
  println(sum(list))

  def test(x: Int):String = x match {
    case 0 => "Hello"
    case 1 => "Learning Scala"
    case _ => "Good Luck!"
  }
  println(test(0))
  println(test(1))
  println(test(2))

}
