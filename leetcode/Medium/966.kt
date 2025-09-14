class Solution {
    fun spellchecker(wordlist: Array<String>, queries: Array<String>): Array<String> {
        val answer = Array(queries.size) { "" }
        val perfectWordList = mutableSetOf<String>()
        val lowerCaseMap = mutableMapOf<String, String>()
        val removeVowelMap = mutableMapOf<String, String>()

        val vowelRegex: Regex = "[aeiou]".toRegex()

        for (word in wordlist) {
            perfectWordList.add(word)

            val lowerCaseWord = word.lowercase()

            lowerCaseMap.putIfAbsent(lowerCaseWord, word)

            removeVowelMap.putIfAbsent(lowerCaseWord.replace(vowelRegex, "*"), word)
        }

        for (index in queries.indices) {
            val query: String = queries[index]

            if (perfectWordList.contains(query)) {
                answer[index] = query

                continue
            }

            val lowerQuery = query.lowercase()

            if (lowerCaseMap.containsKey(lowerQuery)) {
                answer[index] = lowerCaseMap[lowerQuery]!!

                continue
            }

            val removeVowel = lowerQuery.replace(vowelRegex, "*")

            if (removeVowelMap.containsKey(removeVowel)) {
                answer[index] = removeVowelMap[removeVowel]!!

                continue
            }
        }

        return answer
    }
}

fun main() {
    val result1 = Solution().spellchecker(
        arrayOf("KiTe", "kite", "hare", "Hare"),
        arrayOf("kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto")

    )

    println(result1.joinToString(","))

    val result2 = Solution().spellchecker(
        arrayOf("yellow"), arrayOf("YellOw")
    )

    println(result2.joinToString(","))
}
