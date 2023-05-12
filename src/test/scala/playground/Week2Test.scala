package playground

import org.scalatest.flatspec.AnyFlatSpec

class Week2Test extends AnyFlatSpec{
    val lonelyinteger = "lonelyinteger"
    val gradingStudents = "gradingStudents"
    val flippingBits = "flippingBits"
    val diagonalDifference = "diagonalDifference"
    val countingSort = "countingSort"
    val countingValleys = "countingValleys"
    val pangrams = "pangrams"
    val marsExploration = "marsExploration"

    val lonelyintegertest1: (Int, Array[Int]) = (1, Array(5,9,9,5,7,8,8,7,1,3,9,3,7))
    val lonelyintegertest2: (Int, Array[Int]) = (9, Array(5,0,9,5,7,8,8,0,0,3,7,3,7))
    val lonelyintegertest3: (Int, Array[Int]) = (114, Array(1,272,81,99,14,14,272,1,81,99,114,14,8,88,88,8,900,900,1245,900,1245,81,99))
    lonelyinteger should s"return ${lonelyintegertest1._1} when given ${lonelyintegertest1._2.mkString("[",",","]")} " in {
        val expected = lonelyintegertest1._1
        val actual = Week2.lonelyinteger(lonelyintegertest1._2)
        assert(actual === expected)
    }

    it should s"return ${lonelyintegertest2._1} when given ${lonelyintegertest2._2.mkString("[", ",", "]")} " in {
        val expected = lonelyintegertest2._1
        val actual = Week2.lonelyinteger(lonelyintegertest2._2)
        assert(actual === expected)
    }

    it should s"return ${lonelyintegertest3._1} when given ${lonelyintegertest3._2.mkString("[", ",", "]")} " in {
        val expected = lonelyintegertest3._1
        val actual = Week2.lonelyinteger(lonelyintegertest3._2)
        assert(actual === expected)
    }

    val gradingStudents1 = (Array(45,13,81), Array(43,13,81))
    val gradingStudents2 = (Array(75,67,40,33),Array(73,67,38,33))
    gradingStudents should s"return ${gradingStudents1._1.mkString("[", ",", "]")} when given ${gradingStudents1._2.mkString("[", ",", "]")}" in {
        val expected = gradingStudents1._1
        val actual = Week2.gradingStudents(gradingStudents1._2)
        assert(actual === expected)
    }

    it should s"return ${gradingStudents2._1.mkString("[", ",", "]")} when given ${gradingStudents2._2.mkString("[", ",", "]")}" in {
        val expected = gradingStudents2._1
        val actual = Week2.gradingStudents(gradingStudents2._2)
        assert(actual === expected)
    }

    val flippingbits1 = (2147483648L, 2147483647)
    val flippingbits2 = (4294967294L, 1)
    val flippingbits3 = (4294967295L, 0)
    flippingBits should s"return ${flippingbits1._1} when given ${flippingbits1._2}" in {
        val expected = flippingbits1._1
        val actual = Week2.flippingBits(flippingbits1._2)
        assert(actual === expected)
    }

    it should s"return ${flippingbits2._1} when given ${flippingbits2._2}" in {
        val expected = flippingbits2._1
        val actual = Week2.flippingBits(flippingbits2._2)
        assert(actual === expected)
    }

    it should s"return ${flippingbits3._1} when given ${flippingbits3._2}" in {
        val expected = flippingbits3._1
        val actual = Week2.flippingBits(flippingbits3._2)
        assert(actual === expected)
    }

    val diagonalDifference1 = (2, Array(Array(1,2,3), Array(4,5,6), Array(9,8,9)))
    diagonalDifference should s"return ${diagonalDifference1._1} when given ${diagonalDifference1._2.map(x => x.mkString(",")).mkString(" \\ ")}" in {
        val expected = diagonalDifference1._1
        val actual = Week2.diagonalDifference(diagonalDifference1._2)
        assert(actual === expected)
    }

    val cs = (Array(0,2,0,2,0,0,1,0,1,2,1,0,1,1,0,0,2,0,1,0,1,2,1,1,1,3,0,2,0,0,2,0,3,3,1,0,0,0,0,2,2,1,1,1,2,0,2,0,1,0,1,0,0,1,0,0,2,1,0,1,1,1,0,1,0,1,0,2,1,3,2,0,0,2,1,2,1,0,2,2,1,2,1,2,1,1,2,2,0,3,2,1,1,0,1,1,1,0,2,2), Array(63,25,73,1,98,73,56,84,86,57,16,83,8,25,81,56,9,53,98,67,99,12,83,89,80,91,39,86,76,85,74,39,25,90,59,10,94,32,44,3,89,30,27,79,46,96,27,32,18,21,92,69,81,40,40,34,68,78,24,87,42,69,23,41,78,22,6,90,99,89,50,30,20,1,43,3,70,95,33,46,44,9,69,48,33,60,65,16,82,67,61,32,21,79,75,75,13,87,70,33))
    val cs2 = (Array(2,0,1,0,0,1,1,1,1,0,0,1,3,2,2,0,4,4,1,1,0,0,0,0,3,0,0,1,0,1,2,0,1,2,2,3,0,2,0,0,1,0,1,1,0,0,1,1,0,2,0,0,1,1,1,0,1,0,1,1,2,3,0,1,2,0,1,2,1,1,4,1,0,1,1,3,0,0,2,1,2,3,2,2,2,0,0,1,0,0,0,0,0,0,2,0,1,3,1,0), Array(63,54,17,78,43,70,32,97,16,94,74,18,60,61,35,83,13,56,75,52,70,12,24,37,17,0,16,64,34,81,82,24,69,2,30,61,83,37,97,16,70,53,0,61,12,17,97,67,33,30,49,70,11,40,67,94,84,60,35,58,19,81,16,14,68,46,42,81,75,87,13,84,33,34,14,96,7,59,17,98,79,47,71,75,8,27,73,66,64,12,29,35,80,78,80,6,5,24,49,82))
    countingSort should s"return ${cs._1.mkString("[",",","]")} when given ${cs._2.mkString("[",",","]")}" in {
        val expected = cs._1
        val actual = Week2.countingSort(cs._2)
        assert(actual === expected)
    }

    it should s"return ${cs2._1.mkString("[", ",", "]")} when given ${cs2._2.mkString("[", ",", "]")}" in {
        val expected = cs2._1
        val actual = Week2.countingSort(cs2._2)
        assert(actual === expected)
    }

    val countingValleysTest = (1, (8,"UDDDUDUU"))
    val countingValleysTest2 = (2, (12,"DDUUDDUDUUUD"))
    countingValleys should s"return ${countingValleysTest._1} when given ${countingValleysTest._2}" in {
        val expected = countingValleysTest._1
        val actual = Week2.countingValleys(countingValleysTest._2._1, countingValleysTest._2._2)
        assert(actual === expected)
    }

    it should s"return ${countingValleysTest2._1} when given ${countingValleysTest2._2}" in {
        val expected = countingValleysTest2._1
        val actual = Week2.countingValleys(countingValleysTest2._2._1, countingValleysTest2._2._2)
        assert(actual === expected)
    }

    val papangramsTest1 = ("pangram","We promptly judged antique ivory buckles for the next prize")
    val papangramsTest2 = ("not pangram","We promptly judged antique ivory buckles for the prize")
    pangrams should s"return ${papangramsTest1._1} when given ${papangramsTest1._2}" in {
        val expected = papangramsTest1._1
        val actual = Week2.pangrams(papangramsTest1._2)
        assert(actual === expected)
    }

    it should s"return ${papangramsTest2._1} when given ${papangramsTest2._2}" in {
        val expected = papangramsTest2._1
        val actual = Week2.pangrams(papangramsTest2._2)
        assert(actual === expected)
    }

    val marsExplorationTest1 = (0, "SOSSOSSOS")
    val marsExplorationTest2 = (2, "SOSTOSTOS")
    val marsExplorationTest3 = (5, "STBCODSOF")

    marsExploration should s"return ${marsExplorationTest1._1} when given ${marsExplorationTest1._2}" in {
        val expected = marsExplorationTest1._1
        val actual = Week2.marsExploration(marsExplorationTest1._2)
        assert(actual === expected)
    }

    it should s"return ${marsExplorationTest2._1} when given ${marsExplorationTest2._2}" in {
        val expected = marsExplorationTest2._1
        val actual = Week2.marsExploration(marsExplorationTest2._2)
        assert(actual === expected)
    }

    it should s"return ${marsExplorationTest3._1} when given ${marsExplorationTest3._2}" in {
        val expected = marsExplorationTest3._1
        val actual = Week2.marsExploration(marsExplorationTest3._2)
        assert(actual === expected)
    }

}
