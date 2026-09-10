class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // Build the graph: node -> list of (neighbor, weight)
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            double val = values[i];

            graph.computeIfAbsent(u, k -> new HashMap<>()).put(v, val);
            graph.computeIfAbsent(v, k -> new HashMap<>()).put(u, 1.0 / val);
        }

        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);

            // If either variable does not exist in the graph, it cannot be evaluated
            if (!graph.containsKey(src) || !graph.containsKey(dest)) {
                results[i] = -1.0;
            } else if (src.equals(dest)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, src, dest, 1.0, visited);
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String curr, String target, double accProduct, Set<String> visited) {
        visited.add(curr);

        Map<String, Double> neighbors = graph.get(curr);
        if (neighbors.containsKey(target)) {
            return accProduct * neighbors.get(target);
        }

        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            if (!visited.contains(next)) {
                double res = dfs(graph, next, target, accProduct * entry.getValue(), visited);
                if (res != -1.0) {
                    return res;
                }
            }
        }

        return -1.0;
    }
}