class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = mutableMapOf<String, Int>()
        val discountMap = mutableMapOf<String, Int>()
        val windowMax = 10

        for (i in want.indices) {
            wantMap[want[i]] = number[i]
        }

        for (i in discount.indices) {
            val discountItem = discount.get(i)

            if (want.contains(discountItem)) {
                discountMap[discountItem] = discountMap.getOrDefault(discountItem, 0) + 1
            }

            if (wantMap.equals(discountMap)) {
                answer++
            }

            if (i + 1 >= windowMax) {
                val removeName = discount[i - windowMax + 1]

                discountMap[removeName] = discountMap.getOrDefault(removeName, 0) - 1

                if (discountMap.getOrDefault(removeName, 0) <= 0) {
                    discountMap.remove(removeName)
                }
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    Solution_131127()
            .solution(
                    arrayOf("banana", "apple", "rice", "pork", "pot"),
                    intArrayOf(3, 2, 2, 2, 1),
                    arrayOf(
                            "chicken",
                            "apple",
                            "apple",
                            "banana",
                            "rice",
                            "apple",
                            "pork",
                            "banana",
                            "pork",
                            "rice",
                            "pot",
                            "banana",
                            "apple",
                            "banana"
                    )
            )
}
