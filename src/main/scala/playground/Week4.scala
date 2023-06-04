package playground

object Week4 {

    def pickingNumbers(a: Array[Int]): Int = {
        a.sorted.tails
            .map(arr => arr.count(x => x <= arr.head + 1))
            .max
    }

    def rotateLeft(d: Int, arr: Array[Int]): Array[Int] = {
        val rot = d%arr.length
        arr.drop(rot) ++ arr.take(rot)
    }

    def kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String = {
        if(v1 > v2 && (x2-x1)%(v1-v2)==0) "YES" else "NO"
    }

    def main(args: Array[String]): Unit = {
        println(kangaroo(0,2,5,3))
    }

}
