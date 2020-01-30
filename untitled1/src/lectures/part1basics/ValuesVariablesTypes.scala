package lectures.part1basics

object ValuesVariablesTypes extends App {

  // Val : immutable
  val x: Int = 32;
  println(x);

  // Error!!
  //x = 12;

  // Also works - type inference
  val y = 21;
  println(y)

  val str : String = "Soumen Ghosh"

  // mutable
  var z = 32;
  z = 33;
  println(z)

}
