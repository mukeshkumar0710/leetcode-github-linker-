class Solution {
    public int maximumPopulation(int[][] logs) {
        int[] yearChange = new int[101];
        
        for (int[] log : logs) {
            yearChange[log[0] - 1950]++;
            yearChange[log[1] - 1950]--;
        }
        
        int maxPopulation = 0;
        int currentPopulation = 0;
        int earliestYear = 1950;
        
        for (int i = 0; i < 101; i++) {
            currentPopulation += yearChange[i];
            if (currentPopulation > maxPopulation) {
                maxPopulation = currentPopulation;
                earliestYear = 1950 + i;
            }
        }
        
        return earliestYear;
    }
}