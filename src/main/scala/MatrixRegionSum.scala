object MatrixRegionSum {
  def main(args: Array[String]): Unit = {
    val rows = 5
    val cols = 6
    val arr: Array[Array[Int]] = Array.ofDim[Int](rows, cols)
    var i = 1
    for (m <- 0 until rows) {
      for(n <- 0 until cols) {
        arr(m)(n) = i
        i = i + 1
      }
    }

    for (m <- 0 until rows) {
      for (n <- 0 until cols) {
        print(arr(m)(n) + "\t")
      }
      println()
    }
    println("Matrix region sum - " + findMatrixRegionSumMN(arr, a = (1, 1), d = (2, 3)))
  }

  private def findMatrixRegionSumMN(arr: Array[Array[Int]], a: (Int, Int), d: (Int, Int)): Int = {
    var sum = 0
    for (m <- a._1 to d._1) {
      for (n <- a._2 to d._2 ) {
        sum = sum + arr(m)(n)
      }
    }
    sum
  }

}