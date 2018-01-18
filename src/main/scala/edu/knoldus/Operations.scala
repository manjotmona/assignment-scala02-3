package edu.knoldus

import org.apache.log4j.Logger

/**
 * Created by manjot on 17/1/18.
 */
class Operations {
  def length[A](l: List[A]): Int = {
    l.foldRight(0)((_, sum) => sum + 1)
  }

  private def utilityMethod[A](index: Int, list: List[A], sub: List[A]): Boolean = {
    if (list.isEmpty || list.length == 1 && sub.length > 1) {
      false
    }
    else {

      sub match {
        case Nil => true
        case head :: tail if (head == list(index)) => utilityMethod(index + 1, list, tail)
        case head :: tail if (head != list(index)) => hasSubSequence(list, sub)
      }
    }
  }

  def hasSubSequence[A](list: List[A], sub: List[A]): Boolean = {
    if (sub.isEmpty) {
      true
    }
    else {
      list match {
        case Nil => false
        case head :: tail if (head != sub(0)) => hasSubSequence(tail, sub)
        case head :: tail if (head == sub(0)) => utilityMethod(0, list, sub)
      }
    }
  }

  def concatenateList[A](list1: List[A], list2: List[A]): List[A] = {
    def innerConcatenate[A](list1: List[A], list2: List[A], res: List[A]): List[A] = {
      (list1, list2) match {
        case (Nil, Nil) => res
        case (list1, Nil) => list1
        case (Nil, head :: tail) => innerConcatenate(Nil, tail, res :+ head)
        case (list1, _) => innerConcatenate(Nil, list2, list1)

      }
    }

    innerConcatenate(list1, list2, Nil)
  }

  def splitList[A](list: List[A], f: A => Boolean, list1: List[A], list2: List[A]): (List[A], List[A]) = {
    list match {
      case Nil => (list1, list2)
      case head :: tail if (f(head)) => splitList(tail, f, list1 :+ head, list2)
      case head :: tail if (!f(head)) => splitList(tail, f, list1, list2 :+ head)

    }
  }
}

object Application extends App {
  val log = Logger.getLogger(this.getClass)
  val obj = new Operations()
  val one = 1
  val two = 2
  val three = 3
  val four = 4
  val five = 5
  val six = 6
  val list = List(one, two, three, four, five, six)
  log.info(obj.length(list) + "\n")
  log.info(obj.hasSubSequence(list, List(three, four)) + "\n")
  log.info(obj.concatenateList(List(), List(three, four)) + "\n")
  def function(number: Int): Boolean = { number % 2 == 0 }
  log.info(obj.splitList(list, function, Nil, Nil) + "\n")

}







