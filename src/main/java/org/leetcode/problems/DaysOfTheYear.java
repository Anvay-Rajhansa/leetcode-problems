package org.leetcode.problems;

/*

Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

Example 2:
Input: date = "2019-02-10"
Output: 41

Example 3:
Input: date = "2003-03-01"
Output: 60

Example 4:
Input: date = "2004-03-01"
Output: 61

Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31, 2019.

*/

public class DaysOfTheYear {

    public static void main(String[] args) {
        String date = "2016-02-29";

        if(date == null) return;
        String[] splittedDate = date.split("-");

        if(splittedDate.length != 3) return;

        int month = Integer.parseInt(splittedDate[1]);

        if(month > 12 || month < 1) return;

        int year = Integer.parseInt(splittedDate[0]);

        int day = Integer.parseInt(splittedDate[2]);

        if(day > 31 || day < 1) return;

        int total = 0;

        for(int i=1; i < month; i++) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    total += 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    total += 30;
                    break;
                case 2: total += 28; break;
            }
        }

        total += day;

        if((year & 3) == 0 && ((year % 100) != 0 || (year % 400) == 0)) {
            if(month > 2) {
                total += 1;
            }
        }

        System.out.println(total);
    }
}
