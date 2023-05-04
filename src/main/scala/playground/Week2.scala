package playground

object Week2 {

    def lonelyinteger(a: Array[Int]): Int = {
        a.groupBy[Int](identity).find(t => t._2.length == 1).head._1
    }

    def gradingStudents(grades: Array[Int]): Array[Int] = {
        val gradeThreshold = 38
        val roundingThreshold = 3
        def nextMultipleOfFive(i: Int) = 5*((i/5)+1)

        grades.map{grade =>
            if(grade < gradeThreshold) grade
            else
                val nextMultipleOf5 = nextMultipleOfFive(grade)
                grade match
                    case grade if (nextMultipleOf5 - grade < roundingThreshold) => nextMultipleOf5
                    case grade => grade
        }
    }

    def flippingBits(n: Long): Long = {
        (math.pow(2, 32).toLong - 1) - n
    }

    def diagonalDifference(arr: Array[Array[Int]]): Int = {
        val arrLen = arr.length

        def diagonal(posX: Int, posY:Int, res: Int, stepRight: Int) : Int = {
            if(posX > arrLen-1 || posX < 0) res
            else diagonal(posX + stepRight, posY+1, res+arr(posX)(posY), stepRight)
        }

        val l = diagonal(0,0,0,1)
        val r = diagonal(arrLen-1, 0, 0, -1)

        Math.abs(l-r)
    }

}
