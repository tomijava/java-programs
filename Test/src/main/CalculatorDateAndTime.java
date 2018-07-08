package main;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TimeZone;

public class CalculatorDateAndTime {

    public static String toString(ZonedDateTime date) { return "";}

    public static ZonedDateTime calculate(ZonedDateTime date, String operation) {return ZonedDateTime.of(2018,
            6, 26, 0, 0, 0, 0,
            ZoneId.of(TimeZone.getDefault().getID()));}

    public static String showSecondSince(ZonedDateTime date, String input) {return "";}

    public static String whenSunday (ZonedDateTime date) {return "";}
}
