package Algorithms

object LinearSearch extends App{

  println("Linear Seach Implementation.\n")

  println("Enter the size of the array:")
  val size = io.StdIn.readInt()


  var array = Array.ofDim[Int](size)
  println(s"Enter $size element in the array")

  for(i <-0 until size){
    array(i)= io.StdIn.readInt()
  }

  println("The inputted elements are:")
  for (i<- 0 until size){
    print(array(i)+" ")
  }

  println("\nEnter the no. to be searched")
  val search = io.StdIn.readInt()

  var check = -1

  for (i<-0 until size){
    if (array(i)==search)
      check = i
   }

  if (check > -1)
    println(s"Element $search found at $check index.")
  else
    println("Element not found.")


}
