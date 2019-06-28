package Methods

object MapFunction extends App {

  val hello = "hello".map{ _.toUpper}
  println(hello)

  val list = List(1,2,3).map(_*2)
  println(list)

  var array = Array(1,2,3).map(_*2).mkString(" ")
  println("Array: " + array)

  val set = Set(1,3,3,2,2).map(_*2)
  println(set)

  var vector = (0 to 5).map(_*2)
  println(vector)

  var map = Map("key1"-> 1, "key2" ->2).map{keyvalue:(String,Int)=> keyvalue match { case(key, value) => (key, value*2)}  }
  println(map)

  var list1 = Map("key1"-> 1, "key2" ->2).map{case(key, value) => (value*2)}
  println(list1)

  var set1 = Map("key1"-> 1, "key2" ->2).map{ case(key, value) => (value*2) }.toSet
  println(set1)

  var list2 = List(List(1,2,3),  List(4,5,6)).flatten
  println(list2)

  var flatmap = List(1,4,7).flatMap{x => List(x,x+1,x+2) }
  println(flatmap)

  val list3 = List(1,2,3,7,8,9).flatMap{x => if(x>5) List() else List(x) }
  println(list3)


}
