package immutable

import scala.collection.immutable.ListSet

object ListinScala extends App {

//List Implementation

  //comment the below List set implementation before running this List Implementation
  println("Initialisation of immutable list:")
  val list: List[String] = List("A", "B", "C")
  println(s"Elements in list are: $list")

  println("\nAccessing elements of immutable list:")
  println(s"Element at 0 index: ${list(0)}")
  println(s"Element at 1 index: ${list(1)}")
  println(s"Element at 2 index: ${list(2)}")

  println("\nAppending element 'D' at the end of list:")
  val list1 = list :+ "D"
  println(s"After appending elements at the last, the updated list is: $list1")

  println("\nAppending element 'Z' at the front of list:")
  val list2 = "Z" +: list1
  println(s"After appending element at the front, the updated list is: $list2")

  println("\nAppending two immutable list:")
  val appendingTwoList = list ::: list2
  println(s"After appending two list: $appendingTwoList")

  println("\nInitialising empty list:")
  val emptyList = List.empty[String]
  println(s"Empty List: $emptyList")
  //End



  //ListSet Implementation

  //comment the above List implementation before running this ListSet Implementation

  println("Initialisation of immutable listSet:")
  val list: ListSet[String] = ListSet("A", "B", "C")
  println(s"Elements in list are: $list")

  println("\nChecking elements of immutable listSet:")
  println(s"Element A: ${list("A")}")
  println(s"Element B: ${list("B")}")
  println(s"Element C: ${list("C")}")
  println(s"Element D: ${list("D")}")


  println("\nAppending element in listSet:")
  val list2 = list + "D"
  println(s"After appending element, the updated listSet is: $list2")

  println("\nAppending two immutable listSet:")
  val appendingTwoList = list2 ++ ListSet("E")
  println(s"After appending two listSet: $appendingTwoList")

  println("\nRemoving element from listSet:")
  val removingItem = appendingTwoList - "E"
  println(s"After removing element from listSet: $removingItem")

  println("\nInitialising empty listSet:")
  val emptylistSet = ListSet.empty[String]
  println(s"Empty listSet of String: $emptylistSet")
  //End
}
