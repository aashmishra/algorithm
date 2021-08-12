package algo.scala

import scala.util.{Failure, Random, Success, Try}

object OptionAndTry extends App {

//  var ip="1.2.3.4"
//  var port="1234"
//
//  def getIP():Option[String]=Some(ip)
//  def getPort(ip:String):Option[String]=Map("1.2.3.4"->"1234").get(ip)
//  def ping(ip:String, port:String):Option[String]=if(Random.nextBoolean()) Some("Getting Response") else None
//  def Connect(ip:String, port:String):Option[String]=if(Random.nextBoolean()) Some("Connected") else None
//
//
//  val data: Option[String] =     getIP().flatMap(x=>getPort(x).flatMap(y=>ping(x,y)))
//  val data1: Option[Option[String]] =     getIP().flatMap(x=>getPort(x).map(y=>ping(x,y)))
//
//  data match {
//    case Some(x)=>println(x)
//    case None => println("Failed")
//  }
//
//
//
// val dataa =  for{
//    ip<-getIP()
//    port<-getPort(ip)
//    ping<-ping(ip,port)
//   connect<- Connect(ip,port)
//  } yield (ping,connect)
//
//  println(dataa)
//
//  def riskyCodeInvoked(input: String): Int = ???
//
//  def anotherRiskyMethod(firstOutput: Int): String = ???
//
//  def yetAnotherRiskyMethod(secondOutput: String): Try[String] = ???
//
//  val result: Try[String] = Try(riskyCodeInvoked("Exception Expected in certain cases"))
//    .map(anotherRiskyMethod(_))
//    .flatMap(yetAnotherRiskyMethod(_))
//
//  result match {
//    case Success(res) => println("Operation Was successful")
////    case Failure(ex: ArithmeticException) => error("ArithmeticException occurred", ex)
//    case Failure(ex) => println("Operation Was successful")
//  }
  val parseRange: PartialFunction[Any, Int] = {
    case x: Int if x > 10 => x + 1
  }
  println(List(15, 3, "aString") collect { parseRange })


  val sum=(x:Int)=>(y:Int)=> x + y

  val sumf: Int => Int => Int = new (Int => Int => Int){
    def apply(x:Int): Int => Int=new (Int => Int){
      def apply(y:Int):Int=x+y
    }
  }

  val square: Int => Int= new Function[Int,Int] {
    override def apply(v1: Int): Int = v1*v1
  }




  val superadder = sum(10)(5)
  println(superadder)

  //
//  def divide: Try[Int] = {
//    val dividend = Try(Console.readLine("Enter an Int that you'd like to divide:n").toInt)
//    val divisor = Try(Console.readLine("Enter an Int that you'd like to divide by:n").toInt)
//    val problem = dividend.flatMap(x => divisor.map(y => x/y))
//    problem match {
//      case Success(v) =>
//        println("Result of " + dividend.get + "/"+ divisor.get +" is: " + v)
//        Success(v)
//      case Failure(e) =>
//        println("You must've divided by zero or entered something that's not an Int. Try again!")
//        println("Info from the exception: " + e.getMessage)
//        divide
//    }
//  }

}
