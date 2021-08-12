package algo.queue

import java.util

import scala.collection.mutable
import scala.collection.mutable.Queue
import scala.util.{Failure, Success, Try}

class StackUsingQueuePushCostlyScala extends App{


  class MyStack() {

    /** Initialize your data structure here. */
    var q2: mutable.Queue[Int] = scala.collection.mutable.Queue.empty[Int]

    /** Push element x onto stack. */
    def push(x: Int) {
      q2.enqueue(x)
      (1 until q2.size).foreach(x=>
        q2.enqueue(q2.dequeue())
      )
    }

    /** Removes the element on top of the stack and returns that element. */
    def pop(): Int = {
      q2.dequeue()
    }

    /** Get the top element. */
    def top(): Int = {
      import scala.util.{Failure, Success, Try}
      Try {
        q2.front
      } match {
        case Success(x) => x
        case _=> -1
      }
    }

    /** Returns whether the stack is empty. */
    def empty(): Boolean = {
      q2.isEmpty
    }

  }

}
