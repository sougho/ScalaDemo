//package exercises
//
//
//// List Interface
//
//abstract class MyList[+A] {
//  def head : A
//  def tail : MyList[A]
//  def isEmpty : Boolean
//  def add [B >: A ] (value : B) : MyList[B]
//  def printList : String
//  override def toString : String = "[" + printList + "]"
//
//  def map [B] (transformer : A => B) : MyList[B]
//  def filter (predicate : A => Boolean) : MyList[A]
//  def flatMap [B] (transformer : A => MyList[B]) : MyList[B]
//  def ++ [B >: A] (list : MyList[B]) : MyList[B]
//}
//
//object Empty extends MyList[Nothing] {
//
//  def head : Nothing =  throw new NoSuchElementException
//  def tail : MyList[Nothing]  = throw new NoSuchElementException
//  def isEmpty : Boolean = ???
//  def add [B >: Nothing] (value : B ) : MyList[B] = new Cons(value, Empty)
//  def printList = "end"
//
//  def map [B] (transformer : Nothing => B) : MyList[B] = Empty
//  def filter (predicate : Nothing => Boolean) : MyList[Nothing] = Empty
//  def flatMap [B] (transformer : Nothing => MyList[B]) : MyList[B] = Empty
//  def ++ [B >: Nothing] (list : MyList[B]) : MyList[B] = list
//}
//
//class Cons[+A](h : A, t : MyList[A]) extends MyList [A] {
//
//  def head : A =  h
//  def tail: MyList[A]  = t
//  def isEmpty : Boolean = false
//  def add [B >: A] (value : B) : MyList[B] = new Cons(value, this)
//  def printList = h + "," + t.printList
//
//  def map [B] (transformer : A => B) : MyList[B] = new Cons(transformer(head), t.map(transformer))
//  def filter (predicate : A => Boolean) : MyList[A] = {
//    if (predicate(head)) new Cons(head, t.filter(predicate))
//    else t.filter(predicate)
//  }
//
//  def ++ [B >: A] (list : MyList[B])  = {
//    new Cons(head, tail ++ list)
//  }
//  def flatMap [B] (transformer : A => MyList[B]) : MyList[B] = {
//    transformer(h) ++   t.flatMap(transformer)
//  }
//}
//
//object ListTest1 extends App {
//
////  val lst = new Cons(2, Empty)
////  println(lst.add(4).head)
////  println(lst.add(3).add(4).toString())
//
//  val intList  =  new Cons(2, new Cons(3, Empty))
//  println(intList.toString)
//
//  val strList = new Cons("a", new Cons("b", Empty))
//  println(strList.toString)
//
//  // Traits
//
//  val intList1 = new Cons(33, new Cons(34, new Cons(35, Empty)))
//
//  println(intList ++ intList1)
//
//  println(intList1.flatMap( new Int (=> MyList[Int]) {
//    override def apply(elem: Int): MyList[Int] = new Cons(elem, new Cons(elem + 2, Empty))
//  }))
//}