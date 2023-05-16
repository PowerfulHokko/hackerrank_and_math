package playground

import javax.script.ScriptEngineFactory
import scala.annotation.{switch, tailrec}
import scala.util.{Failure, Success, Try}


/* todo:
                    x- adjust return type => List(expression, values, result) : List(String, List[Boolean], Boolean) (wrapped in a Try)
                    - enable expressions for "if", "if and only if"
                    - put parentheses checking in Scala code
                    - make a copy to also accept algebraic expressions
                    - does this work when there is no Python installed? And can I import libraries more dynamically?
*/

object Playground extends App {
    CodeEvaluator.evaluateBooleanExpression("((A ^ B) & C) & A") match
        case Failure(exception) => println(s"${exception.getMessage} :: ${exception.getCause}")
        case Success(value) => value.map(e => s"${e._1} : ${e._2.mkString(", ")} => ${e._3}").foreach(println)
}


object CodeEvaluator {
    import javax.script.ScriptEngineManager

    def evaluateBooleanExpression(expression: String): Try[List[(String, List[Boolean], Boolean)]] = {
        Try{
            val variables = expression.toCharArray.filter(_.isLetter).distinct.map(_.toString).toList

            // Generate variable combinations
            val variableCombinations = generateCombinations(variables)

            // Print table header

            // Evaluate expression for each combination
            variableCombinations.map { combination =>
                val variablesMap = variables.zip(combination).toMap
                val result = evaluateExpression(expression, variablesMap)
                (expression, variablesMap.values.toList, result)
            }
        }
    }

    private def generateCombinations(variables: List[String]): List[List[Boolean]] = variables match {
        case Nil => List(Nil)
        case head :: tail =>
            val tailCombinations = generateCombinations(tail)
            tailCombinations.flatMap(combination => List(false :: combination, true :: combination))
    }

    private def evaluateExpression(expression: String, variables: Map[String, Boolean]): Boolean = {
        import org.python.core.Options
        Options.importSite = false
        val engine = new ScriptEngineManager().getEngineByName("python")
        val transformedExpression: String = expression.toCharArray.map(c => {
            if(variables.contains(c.toString)) s"bool(${variables(c.toString).toString.capitalize})" else c.toString
        }).mkString("")
        engine.eval("result = " + transformedExpression)
        engine.get("result").asInstanceOf[Boolean]
    }
}



