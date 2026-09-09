class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = n - mid; // Number of papers with at least citations[mid] citations

            if (citations[mid] >= count) {
                // Potential h-index found; search left for a potentially larger count
                right = mid - 1;
            } else {
                // citations[mid] is too small; search right
                left = mid + 1;
            }
        }

        return n - left;
    }
}