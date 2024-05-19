object LargestContinuousSum {
  def main(args: Array[String]): Unit = {
    val arr: Array[Int] = Array(2, -1, 2, 2, -4, 2, 1, -3, 5)

    println("Largest continuous sum - " + findLargestContinuousSumN(arr))
  }

  //detect peaks and valleys
  private def findLargestContinuousSumN(arr: Array[Int]): Int = {
    var curr_sum = 0
    var global_sum = 0
    for (i <- arr.indices) {
      if(arr(i) < 0) {
        if(global_sum < curr_sum) {
          global_sum = curr_sum
        }
        curr_sum = 0
      }
      else {
        curr_sum = curr_sum + arr(i)
      }
    }
    Math.max(global_sum, curr_sum)
  }

}