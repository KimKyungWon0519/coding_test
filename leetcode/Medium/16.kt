import kotlin.math.abs

class Solution_16 {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        var minRange = Int.MAX_VALUE
        var answer = -1
        val sortedNums = nums.sorted()

        for (i in 0..<sortedNums.size - 2) {
            val base = sortedNums[i]
            var left = i + 1
            var right = sortedNums.size - 1

            while (left < right) {
                val sum = base + sortedNums[left] + sortedNums[right]

                val range = abs(sum - target)

                println("$sum $range")

                if (minRange > range) {
                    minRange = range
                    answer = sum
                }

                if (sum < target) {
                    left++
                } else if (sum > target) {
                    right--
                } else {
                    return sum
                }
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    val result1 = Solution_16().threeSumClosest(intArrayOf(-1, 2, 1, -4), 1)
    println("answer : $result1")

    val result2 = Solution_16().threeSumClosest(intArrayOf(0, 0, 0), 1)
    println("answer : $result2")
}