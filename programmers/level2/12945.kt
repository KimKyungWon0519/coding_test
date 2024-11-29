class Solution {
    fun solution(n: Int): Int {
        var dp: Array<Int> = Array<Int>(n + 1) { 0 }

        dp[0] = 0
        dp[1] = 1

        for (index in 2..n) {
            dp[index] = dp[index - 1] + dp[index - 2]
        }

        return dp[n] % 1234567
    }
}

fun main() {
    print(Solution().solution(100_000))
}