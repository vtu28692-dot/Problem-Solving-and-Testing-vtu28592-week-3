class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String[] daysOfWeek = {"Friday", "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday"};
        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = 0;

        // 1. Add days for past years since 1971
        for (int y = 1971; y < year; y++) {
            totalDays += isLeapYear(y) ? 366 : 365;
        }

        // 2. Add days for past months in the current year
        for (int m = 0; m < month - 1; m++) {
            totalDays += daysPerMonth[m];
        }

        // If the current year is a leap year and past February, add 1 extra day
        if (month > 2 && isLeapYear(year)) {
            totalDays += 1;
        }

        // 3. Add remaining days of the current month
        totalDays += (day - 1);

        // Map offset from Friday (index 0)
        return daysOfWeek[totalDays % 7];
    }

    private boolean isLeapYear(int y) {
        return (y % 4 == 0 && y % 100 != 0) || (y % 400 == 0);
    }
}