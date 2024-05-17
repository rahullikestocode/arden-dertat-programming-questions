object ArrayPairSum {
  def main(args: Array[String]): Unit = {
    val arr = Array(4, 3, 1, 2, 1)
    val k = 4
    println(findPairsNlogN(arr, k))
    println(findPairsN(arr, k))
  }

  private def findPairsNlogN(arr: Array[Int], k: Int): List[(Int, Int)] = {
    val outputPairs = scala.collection.mutable.ListBuffer.empty[(Int, Int)]
    val sortedArray = arr.sorted
    var i = 0
    var j = arr.length-1

    while(i<j) {
      val ith = sortedArray(i)
      val jth = sortedArray(j)
      val sum = ith+jth
      if(sum==k) {
        val pair = (ith, jth)
        outputPairs+=pair
        i=i+1 //or j=j-1
      } else if(sum>k)
        j=j-1
      else
        i=i+1
    }

    outputPairs.toList
  }

  private def findPairsN(arr: Array[Int], k: Int): List[(Int, Int)] = {
    val seenNumbers = scala.collection.mutable.Set.empty[Int]
    val outputSet = scala.collection.mutable.Set.empty[(Int, Int)]

    for (i <- arr.indices) {
      val n = arr(i)
      val bal = k - n
      if (seenNumbers.contains(bal)){
        outputSet += ((math.min(n, bal), math.max(n, bal)))
      } else {
        seenNumbers += n
      }
    }

    outputSet.toList
  }

}