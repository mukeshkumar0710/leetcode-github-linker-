class Solution {
    private final Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                String leftPart = expression.substring(0, i);
                String rightPart = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(leftPart);
                List<Integer> rightResults = diffWaysToCompute(rightPart);

                // Combine results from left and right sub-expressions
                for (int leftVal : leftResults) {
                    for (int rightVal : rightResults) {
                        if (ch == '+') {
                            results.add(leftVal + rightVal);
                        } else if (ch == '-') {
                            results.add(leftVal - rightVal);
                        } else if (ch == '*') {
                            results.add(leftVal * rightVal);
                        }
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);
        return results;
    }
}