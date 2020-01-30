package lectures.part2OOP

object ObjectBasics extends App {

  // SCALA DOES NOT HAVE CLASS LEVEL FUNCTIONALITY I.E STATIC

  // Scala object is a singleton
  // So this is a type and instance declaration

  object Person {
      // Class level functionality "Static"
      val N_EYES = 2
    def canFly : Boolean = false
      // Factory method
    def fromPersons(father : String, mother : String) : Person = new Person("Bobby")

    def apply(father : String, mother : String) : Person = new Person("Bobby")
  }

  class Person(name : String) {
    // Instance level functionality
  }

  // COMPANIONS

  println(Person.N_EYES)

  val mary = Person
  val john = Person // Same instance is pointed at

  val cindy = new Person("Cindy")
  val david = new Person("David") // Different instances

  val bobbie = Person("a", "b")

  // Scala Application is a scala object
  // with main : e.g.
  // def main (args: Array[String]) : Unit
  // extends App does that same thing


}
