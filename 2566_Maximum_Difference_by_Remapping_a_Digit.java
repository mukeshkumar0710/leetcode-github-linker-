class Solution {
    public int minMaxDifference(int num) {
        String s = Integer.toString(num);
        
        char targetMax = ' ';
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '9') {
                targetMax = s.charAt(i);
                break;
            }
        }
        
        String maxStr = (targetMax == ' ') ? s : s.replace(targetMax, '9');
        
        char targetMin = s.charAt(0);
        String minStr = s.replace(targetMin, '0');
        
        return Integer.parseInt(maxStr) - Integer.parseInt(minStr);
    }
}