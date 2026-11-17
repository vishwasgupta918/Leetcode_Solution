
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int size = m + n;

        int idx1 = (size / 2) - 1;
        int idx2 = size / 2;

        int element1 = 0;
        int element2 = 0;

        int i = 0, j = 0, k = 0;

        while (i < m && j < n) {
            int current;

            if (nums1[i] < nums2[j]) {
                current = nums1[i++];
            } else {
                current = nums2[j++];
            }

            if (k == idx1) {
                element1 = current;
            }

            if (k == idx2) {
                element2 = current;
            }

            k++;
        }

        while (i < m) {
            int current = nums1[i++];

            if (k == idx1) element1 = current;
            if (k == idx2) element2 = current;

            k++;
        }

        while (j < n) {
            int current = nums2[j++];

            if (k == idx1) element1 = current;
            if (k == idx2) element2 = current;

            k++;
        }

        if (size % 2 == 1) {
            return element2;
        }

        return ((double) element1 + element2) / 2;
    }
}
