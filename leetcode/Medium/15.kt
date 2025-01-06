class Solution_15 {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val dp = mutableMapOf<List<Int>, Int>()

        for (i in nums.indices) {
            val n1 = nums[i]

            for (j in i + 1 until nums.size) {
                val n2 = nums[j]

                for (k in j + 1 until nums.size) {
                    val n3 = nums[k]

                    val result = listOf(n1, n2, n3).sorted()

                    if (dp.containsKey(result)) continue

                    dp[result] = result.sum()
                }
            }
        }

        return dp.filter { it.value == 0 }.keys.toList()
    }
}

fun main(args: Array<String>) {
    Solution_15().threeSum(intArrayOf(-1, 0, 1, 2, -1, -4))
}
