/**
 * Example: var li = ListNode(5) var v = li.`val` Definition for singly-linked list. class
 * ListNode(var `val`: Int) {
 * ```
 *     var next: ListNode? = null
 * ```
 * }
 */
import kotlin.math.*

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution_2807 {
    fun insertGreatestCommonDivisors(head: ListNode?): ListNode? {
        var current: ListNode? = head

        while (current != null && current.next != null) {
            val n1: Int = current.`val`
            val n2: Int = current.next!!.`val`

            val gcdValue: Int = gcd(min(n1, n2), max(n1, n2))

            insertNode(current, ListNode(gcdValue))

            current = current.next?.next
        }

        return head
    }

    private fun gcd(n1: Int, n2: Int): Int {
        if (n2 == 0) return n1

        return gcd(n2, n1 % n2)
    }

    private fun insertNode(node: ListNode, newNode: ListNode) {
        newNode.next = node.next
        node.next = newNode
    }
}

fun main(args: Array<String>) {
    val result1: ListNode? =
            Solution_2807()
                    .insertGreatestCommonDivisors(
                            ListNode(18).apply {
                                next =
                                        ListNode(6).apply {
                                            next = ListNode(10).apply { next = ListNode(3) }
                                        }
                            }
                    )

    printNode(result1)

    val result2: ListNode? = Solution_2807().insertGreatestCommonDivisors(ListNode(7))

    printNode(result2)
}

fun printNode(head: ListNode?) {
    var current: ListNode? = head

    while (current != null) {
        print("${current.`val`}\t")

        current = current.next
    }

    println()
}
