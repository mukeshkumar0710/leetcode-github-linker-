import java.util.Arrays;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return 0;
        }

        // Sort intervals in ascending order by their end times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int removed = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            // If current interval starts before previous interval ends, it overlaps
            if (intervals[i][0] < prevEnd) {
                removed++;
            } else {
                // Non-overlapping; update prevEnd to the current interval's end
                prevEnd = intervals[i][1];
            }
        }

        return removed;
    }
}