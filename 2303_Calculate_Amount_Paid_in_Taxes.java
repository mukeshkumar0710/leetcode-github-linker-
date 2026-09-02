class Solution {
    public double calculateTax(int[][] brackets, int income) {
        if (income == 0) {
            return 0.0;
        }

        double totalTax = 0.0;
        int prev = 0;

        for (int[] bracket : brackets) {
            int upper = bracket[0];
            int percent = bracket[1];

            int taxable = Math.min(income, upper) - prev;
            if (taxable > 0) {
                totalTax += (taxable * percent) / 100.0;
                prev = upper;
            }

            if (income <= upper) {
                break;
            }
        }

        return totalTax;
    }
}