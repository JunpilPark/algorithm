import java.util.*
import kotlin.math.max

fun main() {

    val param = arrayOf(
        intArrayOf(0,1),
        intArrayOf(1,2),
        intArrayOf(1,3),
        intArrayOf(2,4))

    // 이 ionput 일 때 오류가 발생함.
    // 문제 파악을 잘 못함. 완전 2진 트리로 항상오는게 아니었음....
    // 노드를 정리하지 않고, 엣지에서 계산해서 쓰도록 했는데 그게 화근 이었음.
    print(Solution().minTime(5, param, listOf(true,true,false,true,true)))
}

class Solution {
    lateinit var visit: BooleanArray
    val visitedNodeStack: Stack<Int> = Stack()

    fun minTime(n: Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {
        visit = BooleanArray(8) { false }
        return max(dsf(0, edges, hasApple) - 2, 0) // Root 는 이전 방문 횟수가 없음
    }

    fun dsf(node:Int, edges: Array<IntArray>, hasApple: List<Boolean>): Int {

        visit[node] = true
        visitedNodeStack.push(node)
        var count = 0

        val childNodes: IntArray = IntArray(2)
        for(i in 0..1) {
            if(node * 2 + i < edges.size) {
                childNodes[i] = edges[node * 2 + i][1]
            }
        }

        if(childNodes.isEmpty() && hasApple[node]) {
            count += 2
            println("$node : count1 - $count")
            return count
        }


        for (i in 0..1) {
            if(!visit[childNodes[i]]) {
                count += dsf(childNodes[i], edges, hasApple)
                println("$node : count2 - $count")
            }
        }
        if(count != 0 || hasApple[node]) {
            count += 2
            println("$node : count3 - $count")
        }
        println("$node : count4 - $count")
        return count
    }

}