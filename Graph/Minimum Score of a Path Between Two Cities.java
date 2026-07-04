/*
You are given a positive integer n representing n cities numbered from 1 to n. You are also given a 2D array roads where roads[i] = [ai, bi, distancei]indicates
that there is a bidirectional road between cities ai and bi with a distance equal to distancei. The cities graph is not necessarily connected.

The score of a path between two cities is defined as the minimum distance of a road in this path.
Return the minimum possible score of a path between cities 1 and n.

Note:
A path is a sequence of roads between two cities.
It is allowed for a path to contain the same road multiple times, and you can visit cities 1 and n multiple times along the path.
The test cases are generated such that there is at least one path between 1 and n.
 

Example 1 :
Input : n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
Output : 5
Explanation: The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 4. The score of this path is min(9,5) = 5.
It can be shown that no other path has less score.

Example 2 :
Input : n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
Output : 2
Explanation : The path from city 1 to 4 with the minimum score is: 1 -> 2 -> 1 -> 3 -> 4. The score of this path is min(2,2,4,7) = 2.
 
Constraints :
2 <= n <= 105
1 <= roads.length <= 105
roads[i].length == 3
1 <= ai, bi <= n
ai != bi
1 <= distancei <= 104

There are no repeated edges.
There is at least one path between 1 and n.

*/

//        SOLUTION      //

class Solution {
    public int minScore(int n, int[][] roads){
        List<List<int[]>> list = new ArrayList<>();
        for(int i=0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int[] road: roads){
            list.get(road[0]).add(new int[] {road[1], road[2]});
            list.get(road[1]).add(new int[] {road[0], road[2]});
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;
        int minScore = Integer.MAX_VALUE;
        
        while(!q.isEmpty()){
            int curr = q.remove();

            for(int[] edge : list.get(curr)){
                int neighbor = edge[0];
                int weight = edge[1];

                minScore = Math.min(minScore, weight);

                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    q.add(neighbor);
                }
            }
        }
        return minScore;
    }
}
