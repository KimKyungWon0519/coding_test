class Solution_2942 {
    fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val answers: MutableList<Int> = mutableListOf()

        for(i in words.indices) {
            if(words[i].contains(x)) {
                answers.add(i)
            }
        }

        return answers
    }
}

fun main() {
    val result1 = Solution_2942().findWordsContaining(arrayOf("leet", "code"), 'e')
}