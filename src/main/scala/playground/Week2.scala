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

    def countingSort(arr: Array[Int]): Array[Int] = {
        val mutArr = scala.collection.mutable.ArrayBuffer.fill(100)(0)
        arr.foreach(x => mutArr.update(x, mutArr(x)+1))
        mutArr.toArray
    }

    def countingValleys(steps: Int, path: String): Int = {
        var currentLevel = 0
        var ctValley = 0
        var isInValley = false

        for (step <- path) {
            if (step == 'U') {
                currentLevel += 1
                if (currentLevel == 0 && isInValley) {
                    isInValley = false
                    ctValley += 1
                }
            } else { // step == 'D'
                currentLevel -= 1
                if (currentLevel < 0 && !isInValley) {
                    isInValley = true
                }
            }
        }

        ctValley
    }

    def pangrams(s: String): String = {
       if(s.replace(" ", "").toUpperCase.distinct.length ==26) "pangram" else "not pangram"
    }

    //todo: add tests
    def marsExploration(s: String): Int = {
        val sl = s.sliding(3, 3).toList
        sl.count(_(0) != 'S') +
        sl.count(_(1) != 'O') +
        sl.count(_(2) != 'S')
    }


}
