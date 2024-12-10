class Solution_2981 {
    fun maximumLength(s: String): Int {
        val map: MutableMap<String, Int> = mutableMapOf()
        var answer: String = ""

        for (i in 0 until s.length) {
            for (j in i + 1..s.length) {
                val tempSpecial: String = s.substring(i, j)

                if (map.containsKey(tempSpecial)) {
                    map[tempSpecial] = map[tempSpecial]!! + 1
                } else if (tempSpecial.count { it == tempSpecial.get(0) } == tempSpecial.length) {
                    map[tempSpecial] = 1
                }
            }
        }

        for (entry in map) {
            if (entry.value >= 3 && answer.length < entry.key.length) {
                answer = entry.key
            }
        }

        return if (answer.isBlank()) -1 else answer.length
    }
}

fun main(args: Array<String>) {
    println(Solution_2981().maximumLength("aaaa"))
}
