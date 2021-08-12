package algo.scala

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.util.Success

object MonadPractice extends App{

  case class SafeValue[+T](private val internalValue: T){
    def get: T = synchronized{internalValue}   // constructor=  pure, Unit

    def flatMap[S](transformer:T => SafeValue[S]):SafeValue[S] = synchronized{   //bind or flatmap
      transformer(internalValue)
    }

//    def transform[S](transformer:T => SafeValue[S]):SafeValue[S] = synchronized{//bind or flatMap so we rename transform
    // to flatMap
//      transformer(internalValue)
//    }
  }

  // if we want to convert a string to upper case then we will have to extract transform and wrap in safe value
  //"external API"
  def gimmeSafeValue[T](value:T):SafeValue[T] = SafeValue(value)

  val safeString:SafeValue[String] = gimmeSafeValue("Scala is awesome")
  //extract
  val string  =safeString.get
  //transform
  val upperString = string.toUpperCase()
  //wrap
  val upperSafeString = SafeValue(upperString)
  // ETW


  // monad help you do it one line so etw patter is compressed like this
  val upperSafeString2 = safeString.flatMap(x=> SafeValue(x.toUpperCase))

  // Monads example 2

  case class Person(firstName: String, lastName:String){
    assert(firstName !=null && lastName !=null)
  }

  //census API
  def getPerson(firstName: String, lastName: String):Person={
    if(firstName !=null) {
      if(lastName !=null){
        Person(firstName,lastName)
      } else null
    } else null
  }

  // Now suppose you dont wanna do that much mess so here is what you can do by using Option which are Monads
  // here flatMap would take care of null check as synchronized was doing in our previos transform
  // function
  def getPersonBetter(firstName: String, lastName: String): Option[Person] ={
    Option(firstName).flatMap{ fname=>
      Option(lastName).flatMap { lname =>
        Option(Person(fname, lname))
      }
      }
  }

  // you can also write it using for loop as below
  def getPersonFor(firstName: String, lastName: String):Option[Person] = for{
    fName <- Option(firstName)
    lName <- Option(lastName)
  } yield Person(fName,lName)



  //Example 3 :Asynchronous fetches
  case class User(id: String)
  case class Product(code: String, price: Double)

  def getUser(url: String): Future[User] = Future{
    User("Ashish")  //sample implementation but may be u wanna get it from http in ur code
  }

  def getLastOrder(userId:String):Future[Product] = Future{
    Product("3445-345",20.76) //sample
  }

  val url_sample = "20.23.23.43/getUser/ashish"

  //ETW pattern so a person would use onComplete
  getUser(url_sample).onComplete{
    case Success(User(id))=>
      val lastOrder= getLastOrder(id)
      lastOrder.onComplete{
        case Success(Product(code, price))=>
          val vatPrice  = price*1.18 // indian vat
        //pass it as a email to Ashish .. some code after it
      }
  }

 val vatIncludedPrice: Future[Double] =
   getUser(url_sample).
   flatMap(user=>  getLastOrder(user.id)).
     map(prod=> prod.price*1.18)


  val vatIncludedPriceFor: Future[Double] =
    for{
      user <- getUser(url_sample)
     lastOrder<- getLastOrder(user.id)
    } yield lastOrder.price*1.18


  // double for loop

  val numbers = List(1,2,3)
  var chars = List('a','b','c')
    // flatMap

  val checkerBorad: List[(Char, Int)] = numbers.flatMap(number=>chars.map(char=> (char,number)))

  val checkerBoardFor = for{
    number <- numbers
    char<- chars
  } yield (char, number)


  //properties
  //Prop 1
  def twoConsecutives(x:Int) = List(x, x+1)
  twoConsecutives(3) //List(3,4)

  List(3).flatMap(twoConsecutives)  // List(3,4)

  //Monad(x).flatMap(f) ==f(x)

  // Prop 2

  List(1,2,3).flatMap(x=> List(x)) // List(1,2,3)

  //Monad(v).flatMap(x=> Monad(x))  USELESS , returns Monad(V)s same; but monad respects this prop

  // Prop 3 associativity

  val incremetor = (x:Int) =>List(x,x+1)
  val doubler = (x:Int) => List(x,2*x)


  print(numbers.flatMap(incremetor).flatMap(doubler)) // List(1,2,2,4 ,   2,4,3,6,   3,6,4,8)
  print(numbers.flatMap(x=>incremetor(x).flatMap(doubler))) // List(1,2,2,4 ,   2,4,3,6,   3,6,4,8)
  /**
    * List(
    * incrementor(1).flatMap(doubler) --1,2,2,4
    * incrementor(2).flatMap(doubler) --2,4,3,6
    * incrementor(3).flatMap(doubler) --3,6,4,8)
    *
    *
    * Monad(V).flatMap(f).flatMap(g) == Monad(V).flatMap(x=>f(x).flatMap(g))  //associative
    * Sequencial associativity
    */




}