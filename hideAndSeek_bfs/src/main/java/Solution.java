import java.util.LinkedList;
import java.util.Queue;

/**
 * 문제
 * 수빈이는 동생과 숨바꼭질을 하고 있다. 수빈이는 현재 점 N(0 ≤ N ≤ 100,000)에 있고, 동생은 점 K(0 ≤ K ≤ 100,000)에 있다. 수빈이는 걷거나 순간이동을 할 수 있다. 만약, 수빈이의 위치가 X일 때 걷는다면 1초 후에 X-1 또는 X+1로 이동하게 된다. 순간이동을 하는 경우에는 1초 후에 2*X의 위치로 이동하게 된다.
 * 수빈이와 동생의 위치가 주어졌을 때, 수빈이가 동생을 찾을 수 있는 가장 빠른 시간이 몇 초 후인지 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫 번째 줄에 수빈이가 있는 위치 N과 동생이 있는 위치 K가 주어진다. N과 K는 정수이다.
 *
 * 출력
 * 수빈이가 동생을 찾는 가장 빠른 시간을 출력한다.
 */
public class Solution {

    public int solution(int subinPos, int brotherPos) {
        int[] visit = new int[100_000];
        Queue<Integer> queue = new LinkedList<>();
        int time = 0;

        visit[subinPos] = 1;
        queue.add(subinPos);

        while(!queue.isEmpty()) {
            int visitedPos = queue.poll();
            int visitedLevel = visit[visitedPos];
            if(visitedPos == brotherPos) {
                time =  visitedLevel - 1;
                break;
            }
            visit(walk(visitedPos), visit, visitedLevel, queue);
            visit(walkBack(visitedPos), visit, visitedLevel, queue);
            visit(teleport(visitedPos), visit, visitedLevel, queue);
        }

        return time;
    }

    private void visit(int pos, int[] visit, int level, Queue<Integer> queue) {
        if(visit[pos] == 0) {
            visit[pos] = level + 1;
            queue.add(pos);
        }
    }

    private int walk(int currentPos) {
        return currentPos + 1;
    }

    private int walkBack(int currentPos) {
        return currentPos - 1;
    }

    private int teleport(int currentPos) {
        return 2 * currentPos;
    }
}
