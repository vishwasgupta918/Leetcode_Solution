class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] freq = new int[n + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            freq[item[0]]++;
            minPrice = Math.min(minPrice, item[1]);
        }

        // Count how many item types have factors divisible by each factor.
        int[] cnt = freq.clone();

        for (int f = 1; f <= n; f++) {
            for (int multiple = 2 * f; multiple <= n; multiple += f) {
                cnt[f] += freq[multiple];
            }
        }

        // Group bonus-producing purchases by price.
        TreeMap<Integer, Long> slots = new TreeMap<>();

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];
            int gain = cnt[factor] - 1; // Exclude the item itself

            if (gain > 0 && (long) price < 2L * minPrice) {
                slots.merge(price, (long) gain, Long::sum);
            }
        }

        long ans = 0;
        long remaining = budget;

        // Buy the cheapest bonus slots first.
        for (Map.Entry<Integer, Long> entry : slots.entrySet()) {
            int price = entry.getKey();
            long count = entry.getValue();

            long take = Math.min(count, remaining / price);
            remaining -= take * price;
            ans += take * 2;
        }

        // Spend the remaining budget on the cheapest item.
        ans += remaining / minPrice;

        return (int) ans;
    }
}