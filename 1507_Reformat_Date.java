class Solution {
    public String reformatDate(String date) {
        Map<String, String> months = new HashMap<>();
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");

        String[] parts = date.split(" ");
        String dayStr = parts[0].replaceAll("[^0-9]", "");
        if (dayStr.length() == 1) {
            dayStr = "0" + dayStr;
        }

        String monthStr = months.get(parts[1]);
        String yearStr = parts[2];

        return yearStr + "-" + monthStr + "-" + dayStr;
    }
}