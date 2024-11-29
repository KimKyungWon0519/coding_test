class Solution {
    fun solution(arr: IntArray): Int {
        var answer = arr[0]

        for (index in 1 until arr.size) {
            answer = lcm(answer, arr[index])
        }

        return answer
    }

    private  fun lcm(n1: Int, n2: Int): Int {
        return n1 * n2 / gcd(n1, n2)
    }

    private fun gcd(n1: Int, n2: Int): Int {
        return if (n2 == 0) n1
        else gcd(n2, n1 % n2)
    }
}

fun main() {
    println(Solution().solution(intArrayOf(2, 7, 14)))
    println(Solution().solution(intArrayOf(2, 6, 8, 14)))
    println(Solution().solution(intArrayOf(1, 2, 3)))
}