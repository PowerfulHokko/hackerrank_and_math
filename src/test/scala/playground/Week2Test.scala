package playground

import org.scalatest.flatspec.AnyFlatSpec

class Week2Test extends AnyFlatSpec{
    val lonelyinteger = "lonelyinteger"
    val gradingStudents = "gradingStudents"

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

}
