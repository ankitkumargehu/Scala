package BreakingNestedLoop

import scala.util.control.Breaks._


object BreakingLoop extends  App {

  val x, y = 0

  val lst1 = List(1,2,3,4,5)
  val lst2 = List(22,55,88)

  breakable{

    for (x<- lst1){
      println(s"Value of x: $x")

      breakable{
        for (y <-lst2){
          println(s"Value of y: $y")
          if (y==55)
            break
        }
      }
    }
  }

}
