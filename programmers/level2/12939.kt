class Solution {
    fun solution(s: String): String {
        var answer = ""
        val numbers: List<Int> = s.split(" ").map { it.toInt() }

        return "${numbers.minOrNull()} ${numbers.maxOrNull()}"
    }
}

fun main() {
    print(Solution().solution("1 2 3 4"))
}