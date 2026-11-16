class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[numCourses];

        for(int[] pair : prerequisites){
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i< numCourses; i++){
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }

        int completedCourses = 0;
        while(!queue.isEmpty()){
            int current = queue.poll();
            completedCourses++;

            for(int nextCourse : adj.get(current)){
                inDegree[nextCourse]--;
                if(inDegree[nextCourse] == 0){
                    queue.offer(nextCourse);
                }
            }
        }
        return completedCourses == numCourses;
    }
}