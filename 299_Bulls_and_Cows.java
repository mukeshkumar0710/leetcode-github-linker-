class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0;
        int cows = 0;
        int[] counts = new int[10];

        for (int i = 0; i < secret.length(); i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);

            if (s == g) {
                bulls++;
            } else {
                // If secret character was previously seen in guess
                if (counts[s - '0'] < 0) {
                    cows++;
                }
                // If guess character was previously seen in secret
                if (counts[g - '0'] > 0) {
                    cows++;
                }

                counts[s - '0']++;
                counts[g - '0']--;
            }
        }

        return bulls + "A" + cows + "B";
    }
}