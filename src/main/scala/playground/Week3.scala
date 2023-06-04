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
        arr.groupBy(identity).filter(t => t._2.length == 2).keys.toList.sorted.head
        /*
            Solution in python because scala code would not compile on hackerank

            def migratoryBirds(arr):
            count = {}
            max_count = 0
            result = None

            for bird in arr:
                count[bird] = count.get(bird, 0) + 1
                if count[bird] > max_count or (count[bird] == max_count and bird < result):
                    max_count = count[bird]
                    result = bird

            return result

        */
    }

    def maximumPerimeterTriangle(sticks: Array[Int]): Array[Int] = {
        object IntArrayOrdering extends Ordering[Array[Int]]{
            override def compare(x: Array[Int], y: Array[Int]): Int = y.sum.compareTo(x.sum)
        }

        sticks
            .combinations(3)
            .map(x=> x.sorted.reverse)
            .distinct
            .map(x => x.sorted.reverse)
            .filter(x => x.head < x(1)+x(2))
            .toList
            .sorted(IntArrayOrdering)
            .headOption.map(_.reverse)
            .getOrElse(Array(-1))
    }

    def pageCount(n: Int, p: Int): Int = {
        //1     2,3|     4,5    6
        val isBeginOrEnd = (i : Int) =>{
            (i == 1) ||  (n % 2 != 0 && p >= n - 1) || (n % 2 == 0 && p == n)
        }

        p match{
            case x if(isBeginOrEnd(x)) => {0}
            case x if ( n%2 == 0 && (x == n-1)) => 1
            case _ => {
                if (p > n / 2) {
                    (n - p) / 2
                } else {
                    p / 2
                }
            }
        }
     }

    def getTotalX(a: Array[Int], b: Array[Int]): Int = {
        (a.max to b.min).filter { i =>
            a.length == a.count(x => i % x == 0)
        }.count { i =>
            b.length == b.count(x => x % i == 0)
        }
    }
    
}
