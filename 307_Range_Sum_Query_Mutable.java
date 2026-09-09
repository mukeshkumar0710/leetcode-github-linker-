class NumArray {
    private final int[] nums;
    private final int[] bit;
    private final int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = new int[n];
        this.bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;

        // Propagate difference upward in the 1-indexed Binary Indexed Tree
        for (int i = index + 1; i <= n; i += i & -i) {
            bit[i] += diff;
        }
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private int query(int index) {
        int sum = 0;
        // Accumulate partial sums downwards using lowest set bit
        for (int i = index; i > 0; i -= i & -i) {
            sum += bit[i];
        }
        return sum;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */