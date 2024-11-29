class Solution {
    fun solution(s: String): String {
        return s.split(" ").joinToString(" ") {
            it.lowercase().replaceFirstChar { c -> c.uppercase() }
        }
    }
}

fun main() {
    val answer = Solution().solution("for the last week")

    print(answer)
}