class Solution_73 {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        val cols: MutableSet<Int> = mutableSetOf()
        val rows: MutableSet<Int> = mutableSetOf()

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                if (matrix[i][j] == 0) {
                    cols.add(i)
                    rows.add(j)
                }
            }
        }

        println(cols)
        println(rows)

        for (col in cols) {
            for (i in matrix[col].indices) {
                matrix[col][i] = 0
            }
        }

        println(matrix.map { "${it.joinToString()}\n" })

        for (row in rows) {
            for (i in 0 until matrix.size) {
                matrix[i][row] = 0
            }
        }

        println(matrix.map { "${it.joinToString()}\n" })
    }
}

fun main(args: Array<String>) {
    Solution_73().setZeroes(arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 0, 1), intArrayOf(1, 1, 1)))
    Solution_73()
            .setZeroes(
                    arrayOf(intArrayOf(0, 1, 2, 0), intArrayOf(3, 4, 5, 2), intArrayOf(1, 3, 1, 5))
            )
}
