package algo.MCollections

object CreateEmployeeMap extends App {

  case class Employee(name:String, age:Int)
  def createMap(empList: List[Employee]):Map[Int, List[Employee]]={
    empList.tail.foldLeft(Map(empList.head.age-> List(empList.head)))((mp, currentElement)=>
    if(mp.keySet.exists(_==currentElement.age)){
     mp + (currentElement.age->(mp(currentElement.age) :+ currentElement))
    } else {
      mp + (currentElement.age->List(currentElement))
    }
    )

  }
   val data = List(
     Employee("Ashish",10),
     Employee("Ajay",10),
     Employee("Manoj",12),
     Employee("Sheela",13),
     Employee("Leela",13)
   )

  println(createMap(data))
}
