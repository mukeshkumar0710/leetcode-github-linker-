class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int totalEnergyNeeded = 1;
        for (int e : energy) {
            totalEnergyNeeded += e;
        }

        int hours = Math.max(0, totalEnergyNeeded - initialEnergy);
        int currentExp = initialExperience;

        for (int exp : experience) {
            if (currentExp <= exp) {
                int needed = exp + 1 - currentExp;
                hours += needed;
                currentExp += needed;
            }
            currentExp += exp;
        }

        return hours;
    }
}