class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        boolean[] inStack = new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // Skip characters already included in the result
            if (inStack[ch - 'a']) {
                continue;
            }

            // Pop characters that are lexicographically larger and appear later in the string
            while (!stack.isEmpty() 
                    && stack.peek() > ch 
                    && lastIndex[stack.peek() - 'a'] > i) {
                char removed = stack.pop();
                inStack[removed - 'a'] = false;
            }

            stack.push(ch);
            inStack[ch - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }

        return sb.toString();
    }
}