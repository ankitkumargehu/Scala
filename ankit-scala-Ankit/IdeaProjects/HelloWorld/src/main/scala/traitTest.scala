import scala.collection.mutable.ArrayBuffer


trait Car
case class toyota(name: String ) extends Car
case class suzuki(name: String) extends Car
case class hyundai(name: String) extends Car



trait Pet {
  val name: String
}

class Cat(val name: String) extends Pet
class Dog(val name: String) extends Pet


object traitTest extends App {
  def brand(a: Car): String = a match {
    case toyota (model) => "Toyota model is: " + model
    case suzuki (model) => "Suzuki Model is: " + model
    case hyundai (model) => "Hyundai Model is: " + model
    case _ => "Case Mismatch"
  }
  println("Trait Car:")
  println(brand(new toyota("Land Cruiser")))
  println(brand(new suzuki("Nexa")))
  println(brand(new hyundai("Xcent")))
  println(brand(null))

  print("\n \n")
  println("Trait Pet:")
  val dog = new Dog("Harry")
  val cat = new Cat("Sally")

  val animals = ArrayBuffer.empty[Pet]
  animals.append(dog)
  animals.append(cat)
  animals.foreach(pet => println(pet.name))
}



