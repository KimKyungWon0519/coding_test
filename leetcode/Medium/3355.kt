class Solution_3355 {
    fun isZeroArray(nums: IntArray, queries: Array<IntArray>): Boolean {
        val answerSums = IntArray(nums.size + 1) { 0 }

        for (query in queries) {
            answerSums[query[0]] -= 1
            answerSums[query[1] + 1] += 1
        }

        for (index in 1 until answerSums.size) {
            answerSums[index] += answerSums[index - 1]
        }

        for (index in nums.indices) {
            if (nums[index] + answerSums[index] > 0) {
                return false
            }
        }

        return true
    }
}

fun main(args: Array<String>) {

    val result1 = Solution_3355().isZeroArray(intArrayOf(1, 0, 1), arrayOf(intArrayOf(0, 2)))

    println("answer : $result1")

    val result2 =
            Solution_3355()
                    .isZeroArray(
                            intArrayOf(4, 3, 2, 1),
                            arrayOf(intArrayOf(1, 3), intArrayOf(0, 2))
                    )

    println("answer : $result2")

    val result3 =
            Solution_3355()
                    .isZeroArray(
                            intArrayOf(2),
                            arrayOf(
                                    intArrayOf(0, 0),
                                    intArrayOf(0, 0),
                                    intArrayOf(0, 0),
                                    intArrayOf(0, 0)
                            )
                    )

    println("answer : $result3")

    val result4 =
            Solution_3355()
                    .isZeroArray(
                            intArrayOf(1, 2, 1, 0, 0, 0),
                            arrayOf(
                                    intArrayOf(0, 3),
                                    intArrayOf(2, 4),
                            )
                    )

    println("answer : $result4")
}
