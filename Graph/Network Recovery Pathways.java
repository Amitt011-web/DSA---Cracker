/*
You are given a directed acyclic graph of n nodes numbered from 0 to n − 1. This is represented by a 2D array edges of length m, where edges[i] = [ui, vi, costi] indicates a one‑way communication from node ui to node vi with a recovery cost of costi.
Some nodes may be offline. You are given a boolean array online where online[i] = true means node i is online. Nodes 0 and n − 1 are always online.

A path from 0 to n − 1 is valid if:

All intermediate nodes on the path are online.
The total recovery cost of all edges on the path does not exceed k.
For each valid path, define its score as the minimum edge‑cost along that path.

Return the maximum path score (i.e., the largest minimum-edge cost) among all valid paths. If no valid path exists, return -1.

 

Example 1 :
Input : edges = [[0,1,5],[1,3,10],[0,2,3],[2,3,4]], online = [true,true,true,true], k = 10
Output : 3
Explanation : The graph has two possible routes from node 0 to node 3:
Path 0 → 1 → 3
Total cost = 5 + 10 = 15, which exceeds k (15 > 10), so this path is invalid.
Path 0 → 2 → 3
Total cost = 3 + 4 = 7 <= k, so this path is valid.
The minimum edge‐cost along this path is min(3, 4) = 3.
There are no other valid paths. Hence, the maximum among all valid path‐scores is 3.

Example 2:
Input: edges = [[0,1,7],[1,4,5],[0,2,6],[2,3,6],[3,4,2],[2,4,6]], online = [true,true,true,false,true], k = 12
Output: 6
Explanation:
Node 3 is offline, so any path passing through 3 is invalid.
Consider the remaining routes from 0 to 4:
Path 0 → 1 → 4
Total cost = 7 + 5 = 12 <= k, so this path is valid.
The minimum edge‐cost along this path is min(7, 5) = 5.
Path 0 → 2 → 3 → 4
Node 3 is offline, so this path is invalid regardless of cost.
Path 0 → 2 → 4
Total cost = 6 + 6 = 12 <= k, so this path is valid.
The minimum edge‐cost along this path is min(6, 6) = 6.
Among the two valid paths, their scores are 5 and 6. Therefore, the answer is 6.

 

Constraints:
n == online.length
2 <= n <= 5 * 104
0 <= m == edges.length <= min(105, n * (n - 1) / 2)
edges[i] = [ui, vi, costi]
0 <= ui, vi < n
ui != vi
0 <= costi <= 109
0 <= k <= 5 * 1013

online[i] is either true or false, and both online[0] and online[n − 1] are true.
The given graph is a directed acyclic graph,

*/

//        SOLUTION        //            "Binary Search on Answer + Dijkstra's Algorithm (as Helper for verification)"

class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        long maxCost = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];
            if (online[u] && online[v]) {
                graph.get(u).add(new int[]{v, cost});
                maxCost = Math.max(maxCost, cost);
            }
        }
        if (!online[0] || !online[n - 1]) return -1;

        long left = 0;
        long right = maxCost;
        long ans = -1;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (isValid(n, graph, mid, k)) {
                ans = mid;        
                left = mid + 1;
            } else {
                right = mid - 1;   
            }
        }
        
        return (int) ans;
    }
    public boolean isValid(int n, List<List<int[]>> graph, long minThreshold, long k) {
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        dist[0] = 0;
        pq.offer(new long[]{0, 0});
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long currentCost = curr[1];
            if (u == n - 1) {
                return currentCost <= k;
            }
            if (currentCost > dist[u]) continue;
            
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int edgeCost = edge[1];
                if (edgeCost >= minThreshold) {
                    if (currentCost + edgeCost < dist[v]) {
                        dist[v] = currentCost + edgeCost;
                        pq.offer(new long[]{v, dist[v]});
                    }
                }
            }
        }
        return false;
    }
}
