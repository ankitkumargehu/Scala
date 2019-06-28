package Algorithms
import util.control.Breaks._
import scala.util.Sorting._
object BinarySearch extends App {
  println("Binary Search Implementation\n")

  println("Enter the size of the array:")
  val size = io.StdIn.readInt()

  var array = Array.ofDim[Int](size)

  println(s"Enter $size elements in the Array:")
  for (i <- 0 until size) {
    array(i) = io.StdIn.readInt()
  }
  quickSort(array)

  println("The sorted inputted elements are:")
  for (i <- 0 until size) {
    print(array(i) + " ")
  }

  println("\nEnter the element to be Searched: ")
  val searchElement = io.StdIn.readInt()

  var mid, left, flag = 0
  var right = size

  breakable {
    while (left <= right) {
        mid = (left + right-1) / 2
        if (array(mid) == searchElement){
          flag = 1
          break()
        }
        if (array(mid) < searchElement) left = mid + 1
        if (array(mid) > searchElement) right = mid - 1
    }
  }

  if(flag==1 )  println(s"Element $searchElement found at $mid index.")
  else println(s"Element $searchElement not found.")
}

