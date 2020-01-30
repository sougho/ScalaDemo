package lectures.part3functionalprogramming

object AnonymousFunctions extends App
{

  // Anonymous functions
  // More syntactic sugar for the old object stuff
  // Remove even object creation by new etc ..

  val doubler = ( x : Int ) => x * 2

  println (doubler(4))
}
