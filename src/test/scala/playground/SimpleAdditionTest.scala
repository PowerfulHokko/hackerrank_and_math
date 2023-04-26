package playground
import org.scalatest.flatspec.AnyFlatSpec

class SimpleAdditionTest extends AnyFlatSpec {

    "a simple addition" should "do 7 + 5 = 12" in {
        assert(12 === SimpleAddition(5,7))
    }

    it should "do 5 + (-7) = -2" in {
        assert(-2 === SimpleAddition(5, -7))
    }

}
