package lectures.part1basics

object Expressions extends App {

  val x = 1 * 2
  println(x)
  println(1==2)

  // Instructions (DO)  vs. Expressions (VALUES and TYPES)

  val aCondition = true;
  val aConditionalValue = if (aCondition) 22 else 33; // IF Expression

  println(aConditionalValue)
  println (if (aCondition) 22 else 33)

  var i = 0;

  val aWhile = while (i < 10) {
    println(i)
    i += 1
  }

  println(aWhile)

  // NEVER TO WRITE AGAIN
  // EVERYTHING IS AN EXPRESSION

  var aVariable : Int = 1

  // Everything is an expression
  // Assignments are expressions returning unit
  // So are while loops
  // All side effects are in general expressions returning units

  val aWeirdType = (aVariable = 2)
  println(aWeirdType)

  // Code blocks

  val aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z < 2) {
      "hello"
    } else {
      5
    }
  }

  println(aCodeBlock)

}
