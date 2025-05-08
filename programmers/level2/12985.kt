class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 1
        var aCnt = a
        var bCnt = b

        while(aCnt != bCnt) {
            if(aCnt % 2 == 0 && aCnt - 1 == bCnt) {
                break
            } else if(aCnt % 2 != 0 && aCnt + 1 == bCnt) {
                break
            }
            
            aCnt = (aCnt / 2.0 + 0.5).toInt()
            bCnt = (bCnt / 2.0 + 0.5).toInt()

            answer++
        }

        return answer
    }
}