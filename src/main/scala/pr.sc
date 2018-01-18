def hasSubSequence[A](list: List[A], sub: List[A]): Boolean = {
  (list,sub) match {
    case (_,Nil) => true
    case (Nil,_) => false
    case (listHead::listTail,subHead::subTail)  if listHead != subHead => hasSubSequence(listTail,sub)
    case (listHead::listTail,subHead::subTail) if listHead == subHead =>hasSubSequence(listTail,subTail)

  }
}

val list:List[Int] = List(1,2)
val sub:List[Int] = List(1,2,3,4)
hasSubSequence(list,sub)

