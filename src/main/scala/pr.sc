//def concateList[A](l1:List[A],l2:List[A]):List[A] = {
//  def innerConcatenate[A](l1:List[A],l2:List[A],res:List[A]):List[A] ={
//    (l1,l2) match {
//      case (Nil,Nil) => res
//      case (l1,Nil) => l1
//
//      case (l1,_)=>innerConcatenate(Nil,l2,l1)
//      case(Nil,head::tail) => innerConcatenate(Nil,tail,res :+ head)
//    }
//  }
//  innerConcatenate(l1,l2,Nil)
//}




//def concateList1[A](list_1:List[A],list_2:List[A]):List[A]=
//{
//  def innerConcat(list_1:List[A],list_2:List[A],list_3:List[A]):List[A]=
//  {
//    (list_1,list_2)match {
//      case (Nil,Nil)=>list_3
//      case(list_1,Nil)=> list_1
//      case (Nil,x::tail)=>innerConcat(Nil,tail,list_3:+x)
//      case (x::tail,list_2)=>innerConcat(tail,list_2,list_3:+x)
//    }
//  }
//  innerConcat(list_1,list_2,Nil)
//}
//
//concateList1(List(1,2),List())