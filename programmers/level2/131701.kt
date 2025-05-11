class Solution_131701 {
    fun solution(elements: IntArray): Int {
        val values: MutableSet<Int> = mutableSetOf()

        values.add(elements.sum())

        for(i in 1..elements.size - 1) {
            var sum = 0

            println("i $i")

            for(j in 0 until elements.size + i - 1) {
                var index = j

                if(index > elements.size - 1) {
                    index -= elements.size
                }

                println("add : ${elements.get(index)}")

                sum += elements.get(index)

                if(j >= i - 1) {
                    println("result : $sum")

                    values.add(sum)

                    println("remove : ${elements.get(j - i + 1)}")

                    sum -= elements.get(j - i + 1)
                }
            }

            println(values)
        }

        println(values.size)

        return values.size
    }
}

fun main(args: Array<String>) {
    Solution_131701().solution(intArrayOf(7, 9, 1, 1, 4))
}