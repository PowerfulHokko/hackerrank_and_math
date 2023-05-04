package playground

import scala.annotation.switch

object Playground extends App {
    1.to(35, 2).toList.foreach(x => println(s"$x - "))
}
