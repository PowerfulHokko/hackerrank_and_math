package playground

import java.util.Scanner
import scala.io.StdIn
import scala.util.{Failure, Success, Try}

object Week3 {
    //todo: testcases
    def twoArrays(k: Int, A: Array[Int], B: Array[Int]): String = {
        if(A.sorted.zip(B.sorted.reverse).exists(t => t._1+t._2 < k)) "NO" else "YES"
    }

    def birthday(s: Array[Int], d: Int, m: Int): Int = {
        s.tails.filter(_.length >= m).map(_.take(m)).count(_.sum == d)
    }

    def getLines: List[String] = {
        def appendLines(collector: List[String]): List[String] = {
            val line = StdIn.readLine()
            if (line.isEmpty) {
                collector.reverse
            } else {
                appendLines(line :: collector)
            }
        }

        val res = appendLines(List.empty[String])
        res
    }

    def xorStrings(a: String, b: String): Try[String] = {
        Try {
            assert(a.length == b.length, "Length of Strings a & b is not equal")
            val aDigits = a.map(_.asDigit)
            val bDigits = b.map(_.asDigit)
            aDigits.foreach(x => assert(x >= 0 && x <= 1, "Non-binary input"))
            bDigits.foreach(x => assert(x >= 0 && x <= 1, "Non-binary input"))
            aDigits.zip(bDigits).map(_ ^ _).mkString("")
        }
    }

    def sockMerchant(n: Int, ar: Array[Int]): Int = {
        ar
            .groupBy(identity)
            .map(t => (t._1, t._2.length))
            .map(t => t._2 / 2)
            .sum
    }

    def migratoryBirds(arr: Array[Int]): Int = {
        // Write your code here
            -1
    }

    def main(args: Array[String]): Unit = {
        println(sockMerchant(0, Array(10,20,20,10,10,30,50,10,20)))
    }

}
