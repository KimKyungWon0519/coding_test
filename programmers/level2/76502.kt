import java.util.Stack

class Solution_76502 {
    fun solution(s: String): Int {
        var answer: Int = 0
        var shiftString = s

        for (i in 0 until s.length) {
            println(shiftString)
            val stack = Stack<Char>()

            for (j in shiftString) {
                println("stack : $stack")

                if (!stack.empty()) {
                    val parenthese: String = "${stack.lastElement()}$j"

                    println("create : $parenthese")

                    if (parenthese == "[]" || parenthese == "{}" || parenthese == "()") {
                        stack.pop()

                        continue
                    }
                }

                stack.push(j)
            }

            println(stack.size)

            if (stack.size == 0) {
                answer++
            }

            println(shiftString.removeRange(0, 1))
            println(shiftString.removeRange(1, shiftString.length))

            shiftString =
                    shiftString.removeRange(0, 1) + shiftString.removeRange(1, shiftString.length)

            println(shiftString)
        }

        return answer
    }
}

fun main(args: Array<String>) {
    println("answer : ${Solution_76502().solution("[](){}")}")
    println("answer : ${Solution_76502().solution("}]()[{")}")
    println("answer : ${Solution_76502().solution("[)(]")}")
    println("answer : ${Solution_76502().solution("}}}")}")
}
