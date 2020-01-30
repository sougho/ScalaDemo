package lectures.part1basics

object Recursion extends App {

  // Taking care of long recursion depth
  // Only tail recursion can use same stack frame
  // therefore supporting long stack depth


  def aFactorial (n : Int ) : BigInt = {
    def fHelper (x : Int, acc : BigInt ) : BigInt = {
      if (x <= 1) acc
      else fHelper (x -1, x * acc)
    }
    fHelper (n, 1)
  }

  println(aFactorial(10))

  println(aFactorial(5000))

}
