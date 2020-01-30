package lectures.part2OOP

object Generics extends App {

  // Parametrized class

  class MyList[+A] {
    def add[B >: A] (element : B) : MyList[B] = ???
  }

  class MyMap[K, V]

  // Objects cannot be parameterized

  object MyList {
    def empty[A] : MyList[A] = ???
  }

  // Variance Problem
  // COVARIANCE, INVARIANCE AND CONTRAVARIANCE

  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // 1. List[Cat] extends List[Animal] - COVARIANCE
  class CovariantList[+A]
  val animal : Animal = new Cat
  val animalList : CovariantList[Animal] = new CovariantList[Cat]
  // Hard Question : What happens when we do animalList.add(new Dog) ?? Ans. We return list of Animals

  // 2. List[Cat] does NOT extend List[Animal] - INVARIANCE
  class InvariantList[A]
  // Not Allowed
  //val invAnimalList : InvariantList[Animal] = new InvariantList[Cat]
  val invAnimalList : InvariantList[Animal] = new InvariantList[Animal]

  // 3. Opposite, CONTRAVARIANCE
  class ContravariantList[-A];
  val contraAnimalList : ContravariantList[Cat] = new ContravariantList[Animal]
  val contraAnimalList1 : ContravariantList[Cat] = new ContravariantList[Cat]

  // Bounded Types
  // <: Subtype
  // >: Supertype

  class   Cage [ A <: Animal] (animal : Animal)
  val cage = new Cage(new Animal) // OK
  val cage1 = new Cage ( new Dog) // OK

  class Car
  // val car = new Cage(new Car) Not OK - Car is not a subtype of Animal



}
