package lectures.part3functionalprogramming

object WhatsAFunction extends App {

  // DREAM : use functions as first class elements
  // Problem : oop - everything is an OBJECT, not a FUNCTION


 val doubler = new MyFunction[Int, Int] {
   override def apply(a : Int) : Int = 2 * a
 }

  println(doubler(4))

  // Function types are already supported
  // Function1 .. Function22

  val strToInt = new  Function1[String, Int] {
    override def apply(s: String): Int = s.toInt
  }

  println(strToInt("44") + 222)

  val adder = new Function2[Int, Int, Int] {
    override def apply (a: Int, b: Int) : Int = a + b
  }

  println(adder(4, 5))

  // Syntactic Sugar = Function2[Int, Int, Int] == ((Int, Int) => Int)

  val adder1 = new ((Int, Int) => Int) {
    override def apply (a: Int, b: Int) : Int = a + b
  }

  println(adder1(4, 5))

  // ALL SCALA FUNCTIONS ARE OBJECTS
  // THIS WAHY B


  // Curried Function
  val superAdder = new ((Int) => ((Int) => Int)) {
    override def apply(a : Int) : (Int) => Int  = {
      new ((Int) => Int) {
        override def apply(b: Int): Int = a + b
      }
    }
  }

  val adder33 = superAdder(33)
  println(adder33(66))
  println(superAdder(22)(44))
}


trait MyFunction[A,B] {
  def apply (a : A) : B
}