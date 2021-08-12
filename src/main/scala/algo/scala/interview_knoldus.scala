package algo.scala

import java.io

import scala.collection.immutable

object interview_knoldus extends App {

 val data = Array("6", "A", "B", "C", "D","F","E","G","P", "A-B", "A-C","C-D","B-F","D-G","G-F","G-H")
 val nodeCount = data(0)
 val edgeNames = data.slice(1, data.length).filterNot(_.contains("-"))
 val links = data.filter(_.contains("-")).flatMap {
  x =>
   val y = x.split("-")
   List((y(0), y(1)), (y(1), y(0)))
 }
 val nodeInfo:Map[String,List[String]]=
  edgeNames.foldLeft(Map.empty[String,List[String]]){ case (aggMap,current )=>
   val left: List[String] = links.filter(_._1.contains(current)).map(_._2).toList
      aggMap ++ Map(current->left)
  }

 for(link <- links){
  println(link)
 }
 for(link <- nodeInfo){
  println(link)
 }

 def findPath(src:String, dest:String,
              nodeInfo:Map[String,List[String]],
              traversed:List[String],
              needToTraverse:List[String],
              path:List[String]
             ):List[String]={

  println("traversed")
  println(traversed)

  println("needToTraverse")
  println(needToTraverse)


  if(needToTraverse.contains(dest)){
       return List(path.mkString("-") + "-" + dest)
      }
  if(needToTraverse.isEmpty){
   return List("-1")
  }

  val result: List[String] = needToTraverse.foldLeft(List.empty[String]){
   case (res,current)=>
      val newNeedToTraverse =
       if(nodeInfo.keySet.contains(current)){
      nodeInfo(current).filterNot(x=>traversed.contains(x)).distinct} else List()

      val finalTraversed:List[String] = traversed ::: needToTraverse
      val newPath:List[String]= path :+ current
      res ::: findPath(src,dest,nodeInfo,finalTraversed,newNeedToTraverse,newPath)
  }

   if(result.distinct.length>1 && result.contains("-1"))
   List(result.filterNot(_.contains("-1")).min)
   else List(result.min)
 }

 val z= findPath("A","H",nodeInfo,List("A"),nodeInfo("A"),List("A"))


 for (x <-z){
  println(x)
 }

// println(links)
}
