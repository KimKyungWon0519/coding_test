class Solution {
    fun solution(s: String): IntArray {
        var convertString = s
        var zeroCount = 0
        var convertCount = 0

        do {
            zeroCount += convertString.count { it == '0' }
            convertString = convertString.replace("0", "")

            val length: Int = convertString.length

            convertString = length.toString(2)

            convertCount++
        } while (convertString.length != 1)

        return intArrayOf(convertCount, zeroCount)
    }
}

fun main() {
    println(Solution().solution("110010101001").joinToString())
}