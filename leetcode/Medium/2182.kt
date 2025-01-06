import kotlin.math.*

class Solution_2182 {
    fun repeatLimitedString(s: String, repeatLimit: Int): String {
        var answer: String = s
        val letterList: IntArray = IntArray('z' - 'a' + 1) { 0 }

        println(letterList.size)

        for (letter in s) {
            letterList[letter - 'a']++
        }

        var currentIndex: Int = letterList.size - 1

        while (currentIndex >= 0) {
            var count: Int = letterList[currentIndex]

            if (count == 0) {
                currentIndex -= 1
                continue
            }

            val useRepeat = min(count, repeatLimit)

            answer += ('a' + currentIndex).toString().repeat(useRepeat)

            count -= useRepeat

            letterList[currentIndex] = count

            if (count > 0) {
                var smallerIndex = currentIndex - 1

                while (smallerIndex >= 0 && letterList[smallerIndex] == 0) {
                    smallerIndex -= 1
                }

                if (smallerIndex < 0) break

                answer += 'a' + smallerIndex

                letterList[smallerIndex] -= 1
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    println(Solution_2182().repeatLimitedString("cczazcc", 3))
    println(Solution_2182().repeatLimitedString("aababab", 2))
}
