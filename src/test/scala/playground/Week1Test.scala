package playground

import org.scalatest.flatspec.AnyFlatSpec

class Week1Test extends AnyFlatSpec {
    val plusMinus = "plusMinus"
    val timeConversion = "timeConversion"
    val breakingRecords = "breakingRecords"
    val camelCase4 = "camelCase4"
    val divisibleSumPairs = "divisibleSumPairs"
    val matchingStrings = "matchingStrings"

    plusMinus should "return 0.500000 0.333333 0.166667 when given [-4, 3, -9, 0, 4, 1]" in {
        val actual = Week1.plusMinus(Array(-4,3,-9,0,4,1))
        val expected = "0.500000 0.333333 0.166667"
        assert(actual === expected)
    }

    it should "return 0.333333 0.333333 0.333333 when given [0, 5, -5]" in {
        val actual = Week1.plusMinus(Array(0,5,-5))
        val expected = "0.333333 0.333333 0.333333"
        assert(actual === expected)
    }

    timeConversion should "convert 07:05:45PM to 19:05:45" in {
        val actual = Week1.timeConversion("07:05:45PM")
        val expected = "19:05:45"
        assert(actual === expected)
    }

    it should "convert 07:05:45AM to 07:05:45" in {
        val actual = Week1.timeConversion("07:05:45AM")
        val expected = "07:05:45"
        assert(actual === expected)
    }

    it should "convert 12:45:30AM to 00:45:30" in {
        val actual = Week1.timeConversion("12:45:30AM")
        val expected = "00:45:30"
        assert(actual === expected)
    }

    it should "convert 12:45:30PM to 12:45:30" in {
        val actual = Week1.timeConversion("12:45:30PM")
        val expected = "12:45:30"
        assert(actual === expected)
    }

    breakingRecords should "return [1,1] when given [12,24,10,24]" in {
        val actual: Array[Int] = Week1.breakingRecords(Array(12,24,10,24))
        val expected: Array[Int] = Array(1,1)

        assert(actual === expected)
    }

    it should "return [2,4] when given [10,5,20,20,4,5,2,25,1]" in {
        val actual: Array[Int] = Week1.breakingRecords(Array(10,5,20,20,4,5,2,25,1))
        val expected: Array[Int] = Array(2, 4)

        assert(actual === expected)
    }

    it should "return [4,0] when given [3,4,21,36,10,28,35,5,24,42]" in {
        val actual: Array[Int] = Week1.breakingRecords(Array(3,4,21,36,10,28,35,5,24,42))
        val expected: Array[Int] = Array(4, 0)

        assert(actual === expected)
    }

    val camelCaseTest1: (String, String) = ("hello world out", "S;M;helloWorldOut()")
    val camelCaseTest2: (String, String) = ("ClassName", "C;C;class name")
    val camelCaseTest3: (String, String) = ("passByRegion()", "C;M;pass by region")
    val camelCaseTest4: (String, String) = ("largestSum", "C;V;largest sum")
    val camelCaseTest5: (String, String) = ("region mapper", "S;C;RegionMapper")
    val camelCaseTest6: (String, String) = ("lowest known point", "S;V;lowestKnownPoint")
    val camelCaseTestList = List(camelCaseTest1, camelCaseTest2, camelCaseTest3, camelCaseTest4, camelCaseTest5)

    camelCase4 should s"return ${camelCaseTest1._1} when given ${camelCaseTest1._2}" in {
        val actual = Week1.camelCase4(camelCaseTest1._2)
        val expected = camelCaseTest1._1
        assert(actual === expected)
    }

    it should s"return ${camelCaseTest2._1} when given ${camelCaseTest2._2}" in {
        val actual = Week1.camelCase4(camelCaseTest2._2)
        val expected = camelCaseTest2._1
        assert(actual === expected)
    }

    it should s"return ${camelCaseTest3._1} when given ${camelCaseTest3._2}" in {
        val actual = Week1.camelCase4(camelCaseTest3._2)
        val expected = camelCaseTest3._1
        assert(actual === expected)
    }

    it should s"return ${camelCaseTest4._1} when given ${camelCaseTest4._2}" in {
        val actual = Week1.camelCase4(camelCaseTest4._2)
        val expected = camelCaseTest4._1
        assert(actual === expected)
    }

    it should s"return ${camelCaseTest5._1} when given ${camelCaseTest5._2}" in {
        val actual = Week1.camelCase4(camelCaseTest5._2)
        val expected = camelCaseTest5._1
        assert(actual === expected)
    }
    
    it should s"return ${camelCaseTest6._1} when given ${camelCaseTest6._2}" in {
        val actual = Week1.camelCase4(camelCaseTest6._2)
        val expected = camelCaseTest6._1
        assert(actual === expected)
    }

    val dsp1 = (3, Array(1,2,3,4,5,6), 5)
    val dsp2 = (5, Array(1,3,2,6,1,2), 3)
    divisibleSumPairs should s"return ${dsp1._1} when given k=${dsp1._3} and arr=${dsp1._2.mkString("[",",","]")}" in {
        val actual = Week1.divisibleSumPairs(dsp1._2.length, dsp1._3, dsp1._2)
        val expected = dsp1._1
        assert(actual === expected)
    }

    it should s"return ${dsp2._1} when given k=${dsp2._3} and arr=${dsp2._2.mkString("[",",","]")}" in {
        val actual = Week1.divisibleSumPairs(dsp2._2.length, dsp2._3, dsp2._2)
        val expected = dsp2._1
        assert(actual === expected)
    }

    val ms1 = (Array(2,1,0), Array("aba","baba","aba","xzxb"),Array("aba","xzxb","ab"))
    val ms2 = (Array(1,0,1), Array("def","de","fgh"),Array("de","lmn","fgh"))
    val ms3 = (Array(1,3,4,3,2), Array("abcde", "sdaklfj", "asdjf", "na", "basdn", "sdaklfj", "asdjf", "na", "asdjf", "na", "basdn", "sdaklfj", "asdjf"),Array("abcde", "sdaklfj", "asdjf", "na", "basdn"))
    matchingStrings should s"return ${ms1._1.mkString("[",",","]")} when given array: ${ms1._2.mkString("[",",","]")} with queries: ${ms1._3.mkString("[",",","]")}" in {
        val actual = Week1.matchingStrings(ms1._2, ms1._3)
        val expected = ms1._1
        assert(actual === expected)
    }

    it should s"return ${ms2._1.mkString("[",",","]")} when given array: ${ms2._2.mkString("[",",","]")} with queries: ${ms2._3.mkString("[",",","]")}" in {
        val actual = Week1.matchingStrings(ms2._2, ms2._3)
        val expected = ms2._1
        assert(actual === expected)
    }

    it should s"return ${ms3._1.mkString("[",",","]")} when given array: ${ms3._2.mkString("[",",","]")} with queries: ${ms3._3.mkString("[",",","]")}" in {
        val actual = Week1.matchingStrings(ms3._2, ms3._3)
        val expected = ms3._1
        assert(actual === expected)
    }

}
