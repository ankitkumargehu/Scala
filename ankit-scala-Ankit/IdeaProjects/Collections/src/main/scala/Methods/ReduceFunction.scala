package Methods

object ReduceFunction extends App {
  val ints = List.range(1, 16)

  def sumWithReduce(ints: List[Int]) = {
    ints.reduce(_ + _)
  }

  println(sumWithReduce(ints))

  println("\nPlaying with number:\n")
  val numbers: Seq[Double] = Seq(1.5, 2.0, 2.5)
  println(s"Numbers are = $numbers")

  val sum: Double = numbers.reduce(_ + _)
  println(s"The sum of the Numbers using reduce function= $sum")

  val sum1: Double = numbers.reduce((a, b) => a + b)
  println(s"The sum of elements using reduce function explicitly= $sum1")

  println(s"Finding cheapest number= ${numbers.reduce(_ min _)}")
  println(s"Finding maximum number= ${numbers.reduce(_ max  _)}")
}
