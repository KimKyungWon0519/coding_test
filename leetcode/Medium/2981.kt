class Solution_2981 {
    fun maximumLength(s: String): Int {
        var special: String = ""
        val dp: MutableList<String> = mutableListOf()

        for (i: Int in 0 until s.length) {
            for (j: Int in i + 1..s.length) {
                val tempSpecial: String = s.substring(i, j)

                if (tempSpecial.count { it == tempSpecial.get(0) } != tempSpecial.length) {
                    continue
                }

                if (dp.contains(tempSpecial)) {
                    continue
                } else {
                    dp.add(tempSpecial)
                }

                val count: Int = getCount(s, tempSpecial)

                if (count >= 3 && special.length < tempSpecial.length) {
                    special = tempSpecial
                }
            }
        }

        return if (special.isNotBlank()) special.length else -1
    }

    private fun getCount(origin: String, special: String): Int {
        var count: Int = 0

        for (i: Int in origin.indices) {
            if (i + special.length > origin.length) {
                break
            }

            val subString: String = origin.substring(i, i + special.length)

            if (subString == special) {
                count++
            }
        }

        return count
    }
}

fun main(args: Array<String>) {
    println(Solution_2981().maximumLength("aaaa"))
}
