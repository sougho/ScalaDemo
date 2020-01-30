package lectures.part1basics

object StringOps extends App  {

  val str : String = "Hello I am learning scala"

  // s-interpolation - value injection
  val v1 = 222
  val v2 = "Soumen"
  val v3 = s"Name : $v2 number ${v1 + 99}"
  println(v3)

  // f-interpolation - formatted
  val speed = 1.2f
  val str1 = f"Name can eat $speed%2.5f burgers per minute"
  println(str1)

}
