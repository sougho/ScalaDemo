package exercises


// List Interface

private abstract class MyList[+A] {
  def head : A
  def tail : MyList[A]
  def isEmpty : Boolean
  def add [B >: A ] (value : B) : MyList[B]
  def printList : String
  override def toString : String = "[" + printList + "]"

  def map [B] (transformer : MyTransformer[A, B]) : MyList[B]
  def filter (predicate : MyPredicate[A]) : MyList[A]
  def flatMap [B] (transformer : MyTransformer[A, MyList[B]]) : MyList[B]
  def ++ [B >: A] (list : MyList[B]) : MyList[B]
}

private object Empty extends MyList[Nothing] {

  def head : Nothing =  throw new NoSuchElementException
  def tail : MyList[Nothing]  = throw new NoSuchElementException
  def isEmpty : Boolean = ???
  def add [B >: Nothing] (value : B ) : MyList[B] = new Cons(value, Empty)
  def printList = "end"

  def map [B] (transformer : MyTransformer[Nothing, B]) : MyList[B] = Empty
  def filter (predicate : MyPredicate[Nothing]) : MyList[Nothing] = Empty
  def flatMap [B] (transformer : MyTransformer[Nothing, MyList[B]]) : MyList[B] = Empty
  def ++ [B >: Nothing] (list : MyList[B]) : MyList[B] = list
}

private class Cons[+A](h : A, t : MyList[A]) extends MyList [A] {

  def head : A =  h
  def tail: MyList[A]  = t
  def isEmpty : Boolean = false
  def add [B >: A] (value : B) : MyList[B] = new Cons(value, this)
  def printList = h + "," + t.printList

  def map [B] (transformer : MyTransformer[A, B]) : MyList[B] = new Cons(transformer.transform(head), t.map(transformer))
  def filter (predicate : MyPredicate[A]) : MyList[A] = {
    if (predicate.test(head)) new Cons(head, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++ [B >: A] (list : MyList[B])  = {
    new Cons(head, tail ++ list)
  }
  def flatMap [B] (transformer : MyTransformer[A, MyList[B]]) : MyList[B] = {
    transformer.transform(h) ++   t.flatMap(transformer)
  }
}


private trait MyPredicate[-T] {
  def test (elem : T) : Boolean
}

private trait MyTransformer[-A, B] {
  def transform(elem : A) : B
}

private object ListTest extends App {

//  val lst = new Cons(2, Empty)
//  println(lst.add(4).head)
//  println(lst.add(3).add(4).toString())

  val intList  =  new Cons(2, new Cons(3, Empty))
  println(intList.toString)

  val strList = new Cons("a", new Cons("b", Empty))
  println(strList.toString)

  // Traits

  val intList1 = new Cons(33, new Cons(34, new Cons(35, Empty)))

  println(intList ++ intList1)

  println(intList1.flatMap( new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 1, Empty))
  }))
}