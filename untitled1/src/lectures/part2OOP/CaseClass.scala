package lectures.part2OOP

object CaseClass extends App {


  // 1.Class parameters are fields
  case class Person (name : String, age : Int)

  val jim = new Person("Jim", 321)
  println(jim.name)

  // 2. Sensible toString

  // 3. equals and hashCode implemented
  val jim2 = new Person("Jim", 321)
  println(jim == jim2)

  // 4. Has copy method

  // 5. Has companion objects

  val thePerson = Person
  val mary = Person("Mary", 33) // Apply method of Person  class

  // 6. Serializable
  // Akka

  // 7. Has extractor patterns - they can be used in PATTERN MATCHING


}
