package playground

import org.scalatest.flatspec.AnyFlatSpec

class Week2Test extends AnyFlatSpec{
    val lonelyinteger = "lonelyinteger"
    val gradingStudents = "gradingStudents"
    val flippingBits = "flippingBits"
    val diagonalDifference = "diagonalDifference"

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

}
