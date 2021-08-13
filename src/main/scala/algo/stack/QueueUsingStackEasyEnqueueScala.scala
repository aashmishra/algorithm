package algo.stack

class QueueUsingStackEasyEnqueueScala extends App {

  /** Initialize your data structure here. */

  var s1= scala.collection.mutable.Stack[Int]()
  var s2= scala.collection.mutable.Stack[Int]()


  /** Push element x to the back of queue. */
  def push(x: Int) {
    //put all in s2
    while(s1.nonEmpty) s2.push(s1.pop());s2.push(x)
    //put all back in s1
    while(s2.nonEmpty)  s1.push(s2.pop())
  }

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int = s1.pop()

  /** Get the front element. */
  def peek(): Int = s1.top

  /** Returns whether the queue is empty. */
  def empty(): Boolean = s1.isEmpty
}
