package playground

import java.util.Scanner
import scala.::
import scala.annotation.tailrec

object Week1 {

    def plusMinus(arr: Array[Int]): String = {
        val n = arr.length
        val count = arr.foldLeft((0, 0, 0)) { case ((pos, neg, zero), num) =>
            if (num > 0) (pos + 1, neg, zero)
            else if (num < 0) (pos, neg + 1, zero)
            else (pos, neg, zero + 1)
        }
        f"${count._1.toDouble / n}%.6f ${count._2.toDouble / n}%.6f ${count._3.toDouble / n}%.6f".replace(",",".")
    }

    def timeConversion(s: String): String = {
        val pattern = "([0-9]{2}):([0-9]{2}):([0-9]{2})(AM|PM)".r
        s match {
            case pattern(hh, mm, ss, "AM") if hh == "12" => s"00:$mm:$ss"
            case pattern(hh, mm, ss, "AM") => s"$hh:$mm:$ss"
            case pattern(hh, mm, ss, "PM") if hh == "12" => s"12:$mm:$ss"
            case pattern(hh, mm, ss, "PM") => s"${hh.toInt + 12}:$mm:$ss"
        }
    }

    def breakingRecords(scores: Array[Int]): Array[Int] = {
        if(scores.length <= 1) return Array(0,0)

        var (min, max) = (scores.head, scores.head)
        case class Record(minCount: Int, maxCount: Int)

        val res: Record = scores.foldLeft(Record(0, 0)) { (record, score) =>
            score match {
                case x if x > max =>
                    max = x
                    Record(record.minCount, record.maxCount + 1)
                case x if x < min =>
                    min = x
                    Record(record.minCount + 1, record.maxCount)
                case _ =>
                    record
            }
        }

        Array(res.maxCount, res.minCount)
    }

    def getInput : String = {
        val sc = new Scanner(System.in);
        val in = sc.nextLine();
        sc.close();
        in
    }

    def camelCase4(str: String) : String = {
        val (m, t, w) : (String, String, String) = {
            val sArr: Array[String] = str.split(";")
            (sArr.head, sArr.tail.head, sArr.tail.tail.head)
        }

        @tailrec
        def splitByCapitalization(str: String, cur: String = "", collector: List[String] = List.empty[String]): List[String] = {
            if (str.isBlank) return (cur :: collector).reverse
            else if (str.head.isUpper) splitByCapitalization(str.tail, "" + str.head, cur :: collector)
            else splitByCapitalization(str.tail, cur + str.head, collector)
        }

        m match
            case "S" =>
                val s1 = w.replace("()", "")
                val s2 = splitByCapitalization(s1)
                s2.map(_.toLowerCase()).mkString(" ").trim
            case "C" =>
                val s1 = w.split(" ").zipWithIndex
                    .map((w: (String, Int)) => {
                        if (!t.equals("C") && w._2 == 0) then w._1
                        else w._1.capitalize
                    }).mkString("")

                if(t.equals("M")) s1 + "()" else s1
    }

    def camelCase4WithLinesFromStdIn: Unit = {
        def getLines: List[String] = {
            val sc = new Scanner(System.in)
            def appendLines(scanner: Scanner, collector: List[String]) : List[String] = {
                if(scanner.hasNextLine){
                    val l = scanner.nextLine();
                    if(l.isEmpty){
                        collector.reverse
                    } else {
                        appendLines(scanner, l::collector)
                    }
                } else {
                    collector.reverse
                }
            }

            val res = appendLines(sc, List.empty[String])

            sc.close()
            res
        }
        val lines = getLines

        lines.map(l => camelCase4(l)).foreach(println)

    }

    def divisibleSumPairs(n: Int, k: Int, ar: Array[Int]): Int = {
        // Helper function to calculate the count of divisible sum pairs
        def recSumP(left: List[Int], count: Int): Int = left match {
            case Nil => count
            case x :: xs =>
                val res = xs.filter(y => (x + y) % k == 0)
                recSumP(xs, count + res.length)
        }

        recSumP(ar.toList, 0)
    }

    def matchingStrings(strings: Array[String], queries: Array[String]): Array[Int] = {
        queries.map(q => strings.count(_.equals(q)))
    }

    /* ----- Playground ----- */
    def main(args: Array[String]): Unit = {

    }
}
