class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;

        // Find maximum pile
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        // Binary Search on eating speed
        while (low < high) {
            int mid = low + (high - low) / 2;

            long hours = 0;

            // Calculate total hours needed
            for (int pile : piles) {
                hours += (pile + mid - 1) / mid;
            }

            if (hours <= h) {
                high = mid;  
            } else {
                low = mid + 1;   
            }
        }

        return low;
    }
}