package algo.window

object MinWindowWindow extends App {

  def compare(map1: Map[Char,Int],expectedMap2: Map[Char,Int]):Boolean={
  map1.keySet.map(x=> map1(x)>=expectedMap2(x)).reduce(_ && _)
  }

  def minWindow(s: String, t: String): String = {
    var start: Int = 0
    var end: Int = 0
    var min: Int = Int.MaxValue
    var max: Int = Int.MaxValue
    var minLength: Int = Int.MaxValue
    var intialMap:Map[Char, Int]=Map()
    t.toCharArray.map(x=>(x,1)).groupBy(_._1).map(x=>(x._1,x._2.map(_._2).sum)).foreach(x=>intialMap += (x._1->x._2))

    var kvMap:Map[Char, Int] = Map()
    t.toCharArray.foreach(x=> kvMap += (x->0))

    //set the start
    while (start<s.length && !kvMap.keySet.contains(s(start))) {
      start += 1
      end +=1
    }


    while (end < s.length && start < s.length) {

      if (kvMap.keySet.contains(s(end))) {
        kvMap += (s(end)->(kvMap(s(end))+ 1))
      }

//      println(kvMap)
        while (start<end && kvMap.getOrElse(s(start),2) > intialMap.getOrElse(s(start),1) ) {
          if(kvMap.getOrElse(s(start),-1) > 1) kvMap += (s(start)->(kvMap(s(start))- 1))
          start += 1
      }

//      println("start-> "+start+" end-> "+end+ "min->"+min+ " max->"+max)
      if (start!=min && end!=max &&  (end - start + 1) < minLength && compare(kvMap,intialMap) ) {
        min = start
        max = end
        minLength = end - start + 1
      }
      end += 1
    }
    s.slice(min,max+1)
  }

  val data= "mADOBmmECODmEmmBANC"
  println(minWindow(data,"mmm"))


}