//Time Complexity : O(nlogn)
class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses,(a,b)->Integer.compare(a[1],b[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int totaltime = 0;
        for(int[] course : courses){
            int duration = course[0];
            int deadline = course[1];

            totaltime += duration;
            pq.offer(duration);
            
            if(totaltime > deadline){
                totaltime -= pq.poll();
            }
        }

        return pq.size();
    }
}