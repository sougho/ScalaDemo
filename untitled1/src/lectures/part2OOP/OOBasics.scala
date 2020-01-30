package lectures.part2OOP

object OOBasics extends App {

  val person  = new Person ("Soumen", 48)
  println(person)
  println(person.age)
  println(person.x)
  person.greet("Humpi")
  person.greet()

  val person1 = new Person("Rumi")
}


// val is needed to make a class parameter
// into a field
// Otherwise not accessible by a . notation
// So class parameters are not class fields by default

// between {} is a block, so one can do anything that one can do in a
// standard block

// Whenever a class is instantiated, the blocks is executed

class Person (name : String, val age : Int) {

  // is a field
  val x  = 2

  println(age)

  def greet(name : String) :Unit = println(s"${this.name} says hi, $name")

  // Overloading

  def greet() : Unit =  println("Hi ")

  // Multiple Constructors
  // The only thing allowed is to call another constructor
  // Primary or secondary

  def this (name : String)  = this(name, 0)

  val count = new Counter(1456)

  println(count.count)
  println(count.inc.count)
  println(count.inc(3).count)

}

class Counter (count:Int) {

  def count () : Int = count

  // Immutability

  def inc  = new Counter(count + 1)

  def inc (n : Int) : Counter = {
    if (n == 0)  this
    else inc.inc(n-1)
  }
}