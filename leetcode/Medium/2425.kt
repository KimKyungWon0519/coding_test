import kotlin.math.*

class Solution_2425 {
    fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
        if (nums1.size % 2 == 0 && nums2.size % 2 == 0) return 0

        if (nums1.size % 2 == 0) {
            var result = 0

            for (num in nums1) {
                result = result.xor(num)
            }

            return result
        } else if (nums2.size % 2 == 0) {
            var result = 0

            for (num in nums2) {
                result = result.xor(num)
            }

            return result
        } else {
            var result = 0
            val all = nums1 + nums2

            for (num in all) {
                result = result.xor(num)
            }

            return result
        }
    }
}

fun main() {
    println(Solution_2425().xorAllNums(intArrayOf(2, 1, 3), intArrayOf(10, 2, 5, 0)))
    println(Solution_2425().xorAllNums(intArrayOf(1, 2), intArrayOf(3, 4)))
}
