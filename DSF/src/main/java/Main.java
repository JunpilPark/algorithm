import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
        graph.add(0, Collections.EMPTY_LIST);
        graph.add(1, List.of(2,3,8));
        graph.add(2, List.of(1,7));
        graph.add(3, List.of(1,4,5));
        graph.add(4, List.of(3,5));
        graph.add(5, List.of(4,3));
        graph.add(6, List.of(7));
        graph.add(7, List.of(1,6,8));
        graph.add(8, List.of(1,7));
        boolean visited[] = new boolean[graph.size()];
        dsf(graph, 1, visited);
        bsf(graph, 1);

        for (Integer node : nodeAfterDSF) {
            System.out.println(node);
        }
        System.out.println("\n");

        for (Integer node : nodeAfterBSF) {
            System.out.println(node);
        }
    }

    public static List<Integer> nodeAfterDSF = new ArrayList<>();
    public static List<Integer> nodeAfterBSF = new ArrayList<>();

    public static void dsf(final List<List<Integer>> graph, Integer currentNodes, boolean[] visited) {
        List<Integer> nodes = graph.get(currentNodes);
        visited[currentNodes] = true;
        nodeAfterDSF.add(currentNodes);

        for (Integer node : nodes) {
            if(!visited[node]) {
                dsf(graph, node, visited);
            }
        }
    }

    public static void bsf(final List<List<Integer>> graph, Integer startNode) {

        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[graph.size()];

        queue.add(startNode);
        visited[startNode] = true;
        nodeAfterBSF.add(startNode);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            List<Integer> nodes = graph.get(node);
            for (Integer _node : nodes) {
                if (!visited[_node]) {
                    queue.add(_node);
                    visited[_node] = true;
                    nodeAfterBSF.add(_node);
                }
            }
        }
    }
}
