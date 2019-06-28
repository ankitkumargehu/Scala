package Basic

object  BasicOpn extends App {

  println(1+1)  // 2
  println("hello" + " world") //hello world

  val x = 1+4 //val = these can't be re-assigned.
  println(x)   //5
   //OR
  val y : Int = 1+1
  println(y)  //2

  //Block
  println({
    val a = 1+1
    a+1
  })  // 3

  //anonymous function with no parameter
  val no = () => 5
  println(no()) //  5


  //anonymous function with one parameter
  val increment = (z: Int) => z + 1
  println(increment(4)) //  5

  // we cam have multi parameters in anonymous function
  val addition   = (m: Int, n: Int) => m + n
  println(addition(4,6)) // 10


  //methods in Scala with parameter
  def add(x: Int, y: Int): Int = x+y
  println(add(4,5))

  //first adding the number and then multiplying
  def addThenMul(x:Int, y: Int)(mul: Int): Int = (x+y) * mul
  println(addThenMul(2, 3)(5))

  //without parameter
  def name: String = System.getProperty("user.name")
  println("user name is: " +name)

  val list: List[Any] = List(
    "a string",
    732,  // an integer
    'c',  // a character
    true, // a boolean value
    (), // => "an anonymous function returning a string"
    1.325 // float
  )

  list.foreach(element => println(element))
}
