class Solution {
    public int minTimeToType(String word) {
        int totalTime = 0;
        char curr = 'a';
        
        for (char target : word.toCharArray()) {
            int diff = Math.abs(target - curr);
            int moves = Math.min(diff, 26 - diff);
            totalTime += moves + 1; // moves + 1 second to type
            curr = target;
        }
        
        return totalTime;
    }
}