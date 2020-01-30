package lectures.part2OOP

object AbstractDatatypes extends App {


  abstract class Animal {
    val creatureType : String
    def eat : Unit
  }

  class Dog extends Animal {
    val creatureType :String = "Dog"
    def eat = println("Chomp")
  }

  val dog : Animal = new Dog
  println(dog.creatureType)

  // Trait

  trait Carnivore {
    def eat (animal : Animal) // Abstract
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {

    val creatureType : String  = "Crocodile"
    def eat = println (" I am crocodile ")
    def eat (animal: Animal ) : Unit =  println(s"I am a croc and I am eating ${animal.creatureType} ")
  }

  val croc : Carnivore = new Crocodile
  croc.eat(dog)

  // Traits vs. Abstract Classes
  // 1. Both can have abstract and non-abstract variables and methods
  // 2. Traits cannot have constructor parameters
  // 3. Can only extends one class but mixin multiple traits
  // 4. Traits are behaviours. Abstract are is-a as usual

}
