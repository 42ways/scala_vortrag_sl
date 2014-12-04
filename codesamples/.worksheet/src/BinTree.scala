// functional data strutures - binary trees

object BinTree {

  abstract class BinTree[+A]
  case object EmptyTree extends BinTree
  case class Node[A](element: A, left: BinTree[A], right: BinTree[A]) extends BinTree[A];import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(391); 

  def inOrder[A](t: BinTree[A]): List[A] = {
    t match {
      case EmptyTree     => List()
      case Node(e, l, r) => inOrder(l) ::: List(e) ::: inOrder(r)
    }
  };System.out.println("""inOrder: [A](t: BinTree.BinTree[A])List[A]""");$skip(266); 

  def depth(t: BinTree[_]): Int = {
    t match {
      case EmptyTree             => 0
      case Node(_, EmptyTree, r) => 1 + depth(r)
      case Node(_, l, EmptyTree) => 1 + depth(l)
      case Node(_, l, r)         => 1 + Math.max(depth(l), depth(r))
    }
  };System.out.println("""depth: (t: BinTree.BinTree[_])Int""");$skip(121); 

  val t = Node(2, Node(1, EmptyTree, EmptyTree), Node(4, Node(3, EmptyTree, EmptyTree), Node(5, EmptyTree, EmptyTree)));System.out.println("""t  : BinTree.Node[Int] = """ + $show(t ));$skip(457); 

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
  };System.out.println("""mkTree: [A](l: List[A])(implicit evidence$1: A => Ordered[A])BinTree.BinTree[A]""");$skip(52); 

  val l = List(7, 9, 2, 5, 8, 4, 0, 1, 5, 6, 2, 3);System.out.println("""l  : List[Int] = """ + $show(l ));$skip(21); 
  val t2 = mkTree(l);System.out.println("""t2  : BinTree.BinTree[Int] = """ + $show(t2 ))}

}
