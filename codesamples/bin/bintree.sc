
object bintree {

  abstract class BinTree[+A]
  case object EmptyTree extends BinTree
  case class Node[A](element: A, left: BinTree[A], right: BinTree[A]) extends BinTree[A]

  def inOrder[A](t: BinTree[A]): List[A] = {
    t match {
      case EmptyTree     => List()
      case Node(e, l, r) => inOrder(l) ::: List(e) ::: inOrder(r)
    }
  }                                               //> inOrder: [A](t: bintree.BinTree[A])List[A]

  def depth(t: BinTree[_]): Int = {
    t match {
      case EmptyTree             => 0
      case Node(_, EmptyTree, r) => 1 + depth(r)
      case Node(_, l, EmptyTree) => 1 + depth(l)
      case Node(_, l, r)         => 1 + Math.max(depth(l), depth(r))
    }
  }                                               //> depth: (t: bintree.BinTree[_])Int

  val t = Node(2, Node(1, EmptyTree, EmptyTree), Node(4, Node(3, EmptyTree, EmptyTree), Node(5, EmptyTree, EmptyTree)))
                                                  //> t  : bintree.Node[Int] = Node(2,Node(1,EmptyTree,EmptyTree),Node(4,Node(3,Em
                                                  //| ptyTree,EmptyTree),Node(5,EmptyTree,EmptyTree)))

  def mkTree[A <% Ordered[A]](l: List[A]): BinTree[A] = {
    def insert(x: A, t: BinTree[A]): BinTree[A] = {
      t match {
        case EmptyTree => Node(x, EmptyTree, EmptyTree)
        case Node(y, l, r) => if (x < y)
          Node(y, insert(x, l), r)
        else if (x > y)
          Node(y, l, insert(x, r))
        else
          t
      }
    }
    l match {
      case Nil     => EmptyTree
      case x :: xs => insert(x, mkTree(xs))
    }
  }                                               //> mkTree: [A](l: List[A])(implicit evidence$1: A => Ordered[A])bintree.BinTre
                                                  //| e[A]

  val l = List(7, 9, 2, 5, 8, 4, 0, 1, 5, 6, 2, 3)//> l  : List[Int] = List(7, 9, 2, 5, 8, 4, 0, 1, 5, 6, 2, 3)
  val t2 = mkTree(l)                              //> t2  : bintree.BinTree[Int] = Node(3,Node(2,Node(1,Node(0,EmptyTree,EmptyTre
                                                  //| e),EmptyTree),EmptyTree),Node(6,Node(5,Node(4,EmptyTree,EmptyTree),EmptyTre
                                                  //| e),Node(8,Node(7,EmptyTree,EmptyTree),Node(9,EmptyTree,EmptyTree))))

}