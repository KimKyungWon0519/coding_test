class Solution_2116 {
    fun canBeValid(s: String, locked: String): Boolean {
        if (s.length % 2 != 0) return false

        var test: CharArray = s.toCharArray()

        val lockedOpen: Stack<Int> = Stack()
        val unlocked: Stack<Int> = Stack()

        for (index in s.indices) {
            if (locked[index] == '0') {
                unlocked.push(index)
            } else if (s[index] == '(') {
                lockedOpen.push(index)
            } else if (s[index] == ')') {
                if (lockedOpen.isNotEmpty()) {
                    lockedOpen.pop()
                } else if (unlocked.isNotEmpty()) {
                    unlocked.pop()
                } else return false
            }
        }

        while (lockedOpen.isNotEmpty() &&
                unlocked.isNotEmpty() &&
                lockedOpen.peek() < unlocked.peek()) {
            lockedOpen.pop()
            unlocked.pop()
        }

        if (lockedOpen.isNotEmpty()) return false

        return true
    }
}

fun main(args: Array<String>) {
    println(Solution_2116().canBeValid("))()))", "010100"))
    println(Solution_2116().canBeValid("()()", "0000"))
    println(Solution_2116().canBeValid(")", "0"))
}
