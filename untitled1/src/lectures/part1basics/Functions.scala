package lectures.part1basics

object Functions extends App{

  def aFn (a: String, b: Int) : String =
    a + " + " + b

  println(aFn("a", 3))

  def aFnNoP () : Int = 42

  println(aFnNoP())
  println(aFnNoP)

  // Loops!! : Recursion

  def aRepeatedFunction (aString : String, n:Int) : String = {
    if (n==1) aString
    else aString +  " " + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("Soumen", 3))

  // Return type Inference

  def aFn1 (a: String, b: Int) =
    a + " + " + b
  // Cannot figure out return type for recursive functions

  // Only Side Effects  - return type Unit
  def aFnSideEffectOnly (a: String)   =
    println(123)

  aFnSideEffectOnly("a")

  // Code Blocks and Nested Functions

  def aNestedFunction (n1 : Int, n2 : Int) : Int = {

    def aFn (n1 : Int, n2 : Int) : Int =
      n1 + n2
    aFn(n1, n2)
  }

  println(aNestedFunction(31, 22))

}
