package lectures.part2OOP

object Inheritence extends App {

  sealed class Animal {

     protected def eat = println("Animal Eat")
  }

  class Cat extends Animal {
    override def eat = {
      println("Cat Eat")
      super.eat
    }
    def doeat(): Unit = eat
  }

  val cat = new Cat
  cat doeat;
  cat eat

  // Constructors

  class Person (name : String, age : Int) {
    def this (name : String) = this (name, 0)
  }
  class Adult (name : String, age : Int, idCard : String) extends Person("me")

  // Value overriding is supported in scala

  class Creature {
    val crType : String = "Creature"
  }

  class Whale (override val crType : String) extends Creature

  val whale = new Whale("Whale")
  val cr = new Creature

  println(whale.crType)
  println(cr.crType)

  // Preventing Override
  // 1. Use final keyword on method
  // 2. Use final on class
  // 3. Seal the class - extend in this FILE only, but prevent extend from outside


}
