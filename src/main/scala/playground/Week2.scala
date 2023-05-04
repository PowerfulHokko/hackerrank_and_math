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





}
