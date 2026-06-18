/*
Given a string s representing time in 24-hour format "HH:MM", compute the smallest angle in degrees between the hour and minute hands of an analog clock.

Examples:
Input: s = "06:00"
Output: 180.000
Explanation: When the time is 06:00, the angle between the hour and minute hands of the clock is 180.000 degrees.

Input: s = "03:15"
Output: 7.500
Explanation: When the time is 03:15, the angle between the hour and minute hands of the clock is 7.500 degrees.

Constraints:
s.size() = 5
00 ≤  HH  ≤ 23
00 ≤  MM  ≤ 59
*/

//       SOLUTION      //

class Solution {
     public double getAngle(String s) {
        String[] parts = s.split(":");

        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);

        if(hour == 12) hour = 0;
        if(hour > 12) hour = hour % 12;

        double angle = Math.abs((hour * 30) - (minute * 5.5));

        if(angle >= 180) angle = 360 - angle;
        return angle;
    }
}
