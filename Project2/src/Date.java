import static java.lang.Math.*;

public class Date {

    private final int year; private int month; private final int day;

    public Date(int dateYears, int dateMonths, int dateDays) {
        year = getYear(dateYears);
        getMonth(dateMonths);
        day = getDay(dateMonths, dateDays);
    }

    private int getDay(int controlMonth, int controlDay) {
        final int day;
        if (controlDay < 1) day = 1;
        else if (controlMonth == 2 && controlDay > 28) day = 28;
        else if ((controlMonth == 4 || controlMonth == 6 || controlMonth == 9 || controlMonth == 11) && controlDay > 30) day = 30;
        else day = min(controlDay, 31);
        return day;
    }

    private void getMonth(int controlMonth) {
        if (controlMonth <= 1) month = 1;
        else if (controlMonth == 2) month = 2;
        else if (controlMonth == 3) month = 3;
        else if (controlMonth == 4) month = 4;
        else if (controlMonth == 5) month = 5;
        else if (controlMonth == 6) month = 6;
        else if (controlMonth == 7) month = 7;
        else if (controlMonth == 8) month = 8;
        else if (controlMonth == 9) month = 9;
        else if (controlMonth == 10) month = 10;
        else if (controlMonth == 11) month = 11;
        else if (controlMonth == 12) month = 12;

    }
    private int getYear(int controlYear) {
        final int year;
        if (controlYear < 1900) year = 1900;
        else year = min(controlYear, 3000);
        return year;
    }

    public int prefComparison(Date date) {
        int diffDays = abs((dayOfYear() + 365 * (year-1)) - (date.dayOfYear() + 365 * (date.year-1)));
        int diffMonths = diffDays / 30;
        return min(diffMonths, 60);
    }

    public int dayOfYear() {
        int totalDays = 0;
        switch (month) {
            case 12:
                totalDays += 30;
            case 11:
                totalDays += 31;
            case 10:
                totalDays += 30;
            case 9:
                totalDays += 31;
            case 8:
                totalDays += 31;
            case 7:
                totalDays += 30;
            case 6:
                totalDays += 31;
            case 5:
                totalDays += 30;
            case 4:
                totalDays += 31;
            case 3:
                totalDays += 28;
            case 2:
                totalDays += 31;
        }
        totalDays += day;
        return totalDays;
    }
}
