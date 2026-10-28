class Solution {
    private final int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public int daysBetweenDates(String date1, String date2) {
        int days1 = daysFrom1900(date1);
        int days2 = daysFrom1900(date2);
        return Math.abs(days1 - days2);
    }
    private int daysFrom1900(String date) {
        int year  = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day   = Integer.parseInt(date.substring(8, 10));
        int totalDays = 0;
        for (int y = 1900; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysInMonth[m];
        }
        if (month > 2 && isLeapYear(year)) {
            totalDays += 1;
        }
        totalDays += day;
        return totalDays;
    }
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}