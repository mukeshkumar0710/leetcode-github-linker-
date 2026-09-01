class Solution {
    public List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        char colStart = s.charAt(0);
        char rowStart = s.charAt(1);
        char colEnd = s.charAt(3);
        char rowEnd = s.charAt(4);

        for (char c = colStart; c <= colEnd; c++) {
            for (char r = rowStart; r <= rowEnd; r++) {
                result.add("" + c + r);
            }
        }

        return result;
    }
}