class Solution {
    public double angleClock(int hour, int minutes) {
        double minutesAngle=minutes*6;
        double hourAngle=hour*30+minutes*0.5;
        double angle=Math.abs(hourAngle-minutesAngle);
        return Math.min(angle,360-angle);
    }
}