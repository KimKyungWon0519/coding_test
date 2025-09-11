// https://leetcode.com/problems/sort-vowels-in-a-string/description/

import kotlin.Char
import kotlin.streams.toList

fun main() {
    println(Solution().sortVowels("lEetcOde"))
    println(Solution().sortVowels("lYmpH"))
}

class Solution {
    fun sortVowels(s: String): String {
        val answer: MutableList<Char> = mutableListOf()
        val vowels: CharArray = charArrayOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
        val sSortedList: List<Char> = s.chars().sorted().toList().map { Char(it) }.filter{ vowels.contains(it) }

        var index = 0

        for(c in s.toCharArray()) {
            if(vowels.contains(c)) {
                answer.add(sSortedList[index++])
            } else {
                answer.add(c)
            }
        }

        return answer.joinToString("")
    }
}