class Solution_87390 {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var answer: IntArray = IntArray((right - left).toInt() + 1)

        for(i in 0 until answer.size) {
            val startValue = (left + i) / n + 1
            val genIndex = (left + i) % n  + 1

            if(genIndex <= startValue) {
                answer[i] = startValue.toInt()
            } else {
                answer[i] = genIndex.toInt()
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    Solution_87390().solution(3, 2, 5)
    println()
    Solution_87390().solution(4, 7, 14)
}
