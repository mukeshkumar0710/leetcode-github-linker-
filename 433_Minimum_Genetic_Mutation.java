class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>(Arrays.asList(bank));

        // If the target gene is not in the bank, it's impossible to reach
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        char[] geneChars = new char[]{'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        Set<String> visited = new HashSet<>();
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String curr = queue.poll();

                if (curr.equals(endGene)) {
                    return mutations;
                }

                char[] currArray = curr.toCharArray();

                // Try mutating each of the 8 characters
                for (int j = 0; j < 8; j++) {
                    char originalChar = currArray[j];

                    for (char c : geneChars) {
                        if (c == originalChar) continue;

                        currArray[j] = c;
                        String nextGene = new String(currArray);

                        // If the mutation is valid and not yet visited
                        if (bankSet.contains(nextGene) && visited.add(nextGene)) {
                            queue.offer(nextGene);
                        }
                    }

                    // Restore the original character for the next position
                    currArray[j] = originalChar;
                }
            }

            mutations++;
        }

        return -1;
    }
}