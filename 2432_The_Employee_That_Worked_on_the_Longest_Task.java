class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int ansId = logs[0][0];
        int maxDuration = logs[0][1];

        for (int i = 1; i < logs.length; i++) {
            int duration = logs[i][1] - logs[i - 1][1];
            int id = logs[i][0];

            if (duration > maxDuration) {
                maxDuration = duration;
                ansId = id;
            } else if (duration == maxDuration) {
                ansId = Math.min(ansId, id);
            }
        }

        return ansId;
    }
}