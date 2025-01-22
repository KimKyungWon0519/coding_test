import java.util.*

class Solution_1765 {
    private val moveX = arrayOf(0, 1, 0, -1)
    private val moveY = arrayOf(-1, 0, 1, 0)

    fun highestPeak(isWater: Array<IntArray>): Array<IntArray> {
        val m = isWater.size
        val n = isWater[0].size

        val visited = Array(m) { Array(n) { false } }
        val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()

        val result = Array(m) { i -> IntArray(n) { j -> if (isWater[i][j] == 1) 0 else -1 } }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (isWater[i][j] == 1) {
                    queue.add(Pair(i, j))
                    visited[i][j] = true
                }
            }
        }

        while (queue.isNotEmpty()) {
            val curIndex = queue.poll()

            for (index in 0..3) {
                val y = curIndex.first + moveY[index]
                val x = curIndex.second + moveX[index]

                if (x in 0 until n && y in 0 until m && !visited[y][x]) {
                    queue.add(Pair(y, x))
                    visited[y][x] = true

                    result[y][x] = result[curIndex.first][curIndex.second] + 1
                }
            }
        }

        return arrayOf()
    }
}

fun main() {
    println(Solution_1765().highestPeak(arrayOf(intArrayOf(0, 1), intArrayOf(0, 0))))
    println(
            Solution_1765()
                    .highestPeak(
                            arrayOf(intArrayOf(0, 0, 1), intArrayOf(1, 0, 0), intArrayOf(0, 0, 0))
                    )
    )
    println(
            Solution_1765()
                    .highestPeak(
                            arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0), intArrayOf(0, 0, 1))
                    )
    )
}
