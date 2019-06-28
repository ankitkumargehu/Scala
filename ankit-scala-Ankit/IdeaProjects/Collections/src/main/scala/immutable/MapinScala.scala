package immutable
import scala.collection.immutable.HashMap

object MapinScala extends App {

  //comment the below HashMap implementation before running this Map Implementation

  // Map implementation
  println("Initialization of Map:")
  val map = Map((1, "A"), (2, "B"), (3, "C"))
  println(s"Element in Map: $map")

  println("\nInitialization of Map using key notation:")
  val keyMap = Map(1 -> "A", 2 -> "B", 3 -> "C")
  println(s"$keyMap")

  println("\nAccessing element by specific key:")
  println(s"key 1: element: ${keyMap(1)}")
  println(s"key 2: element: ${keyMap(2)}")
  println(s"key 3: element: ${keyMap(3)}")

  println("\nAdding element in Map:")
  val elem = map + (4 -> "D")
  println(s"Map after adding an element: $elem")

  println("\nAdding two map together:")
  val add = keyMap ++ elem
  println(s"After adding two Map: $add")

  println("\nRemoving key and its value from Map:")
  val rem = elem - 1
  println(s"After removing key from Map: $rem")

  println("\nInitializing empty Map:")
  val empty = Map.empty[Int, String]
  println(s"$empty")

  val friends = Seq("Malyaj", "Ankit", "Aditi", "Himanshu", "Adisha")
  println(s"BFF are: $friends")
  println("Dropping one firend:")
  println(s"List lenght: ${friends.length}")
  val dropping = friends.drop(friends.length)
  println(s"$dropping")
//End






  //comment the above Map implementation before running this HashMap Implementation

//HashMap implementation


  object MapinScala extends App {

    println("Initialization of HashMap:")
    val hashmap = HashMap((1, "A"), (2, "B"), (3, "C"))
    println(s"Element in Map: $hashmap")

    println("\nInitialization of HashMap using key notation:")
    val keyMap = HashMap(1 -> "A", 2 -> "B", 3 -> "C")
    println(s"$keyMap")

    println("\nAccessing element in HashMap by specific key:")
    println(s"key 1: element: ${keyMap(1)}")
    println(s"key 2: element: ${keyMap(2)}")
    println(s"key 3: element: ${keyMap(3)}")

    println("\nAdding element in HashMap:")
    val elem = hashmap + (4 -> "D")
    println(s"HashMap after adding an element: $elem")

    println("\nAdding two HashMap together:")
    val add = keyMap ++ elem
    println(s"After adding two HashMap: $add")

    println("\nRemoving key and its value from HashMap:")
    val rem = elem - 1
    println(s"After removing key from HashMap: $rem")

    println("\nInitializing empty HashMap:")
    val empty = HashMap.empty[Int, String]
    println(s"$empty")

  }
  //End

}
