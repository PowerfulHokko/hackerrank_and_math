package playground

import scala.annotation.switch

object Playground extends App {
    for{
        i <- (0 to 10).toList
    } yield{
        val res: String = i match
            case i if (i >= 8) => "hello"
            case 7 => "bye"
            case _ => "fuck"

        println(s"$i -> $res")
    }


}
