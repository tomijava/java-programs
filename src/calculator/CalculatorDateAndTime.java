package calculator;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorDateAndTime implements Calculator {
    
    public static final Pattern INPUT_PATTERN_FOR_CALCULATE = Pattern.compile("^([\\+\\-])\\s*((\\d*)y)?\\s*((\\d*)m)?\\s*((\\d*)d)?\\s*((\\d*)h)?\\s*((\\d*)min)?\\s*((\\d*)s)?$");
    // examples +6y 3m 5d, - 5m 3d 5h 3min 8s, - 5d, +6min
    public static final Pattern INPUT_PATTERN_FOR_SHOW_SECONDS_SINCE = Pattern.compile("^showSecondsSince(\\d{1,4})\\s?([1-9]|1[0-2])?\\s?([1-9]|1[0-9]|2[0-9]|3[01])?$");
    // example showSecondsSince 1994 12 05, showSecondsSince 600 7 31;
    private final int NUMBER_OF_YEAR = 1;  
    private final int NUMBER_OF_MONTH = 2;
    private final int NUMBER_OF_DAY = 3;
    private final int OPERATOR = 1;
    private final int YEARS = 3;
    private final int MONTHS = 5;
    private final int DAYS = 7;
    private final int HOURS = 9;
    private final int MINUTES = 11;
    private final int SECONDS = 13;
    private ZonedDateTime zone = ZonedDateTime.now();

    public CalculatorDateAndTime(Zone zone) {
        this.zone = ZonedDateTime.now(ZoneId.of(zone.idZone));
    }
    public String toString() {
        return zone.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public String whenSunday() {
        return "Sunday is " + zone.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public void showSecondsSince(String input) {
        Matcher matcher = INPUT_PATTERN_FOR_SHOW_SECONDS_SINCE.matcher(input);
        matcher.find();
        Duration secondsSince;
        
        if (matcher.group(NUMBER_OF_YEAR) != null && matcher.group(NUMBER_OF_MONTH) != null && matcher.group(NUMBER_OF_DAY) != null) {
            LocalDate localDate = LocalDate.of(Integer.valueOf(matcher.group(NUMBER_OF_YEAR)).intValue(), Integer.valueOf(matcher.group(NUMBER_OF_MONTH)).intValue(), Integer.valueOf(matcher.group(NUMBER_OF_DAY)).intValue());
            secondsSince =  Duration.between(zone, zone.minusYears(localDate.getYear()).minusMonths(localDate.getMonthValue()).minusDays(localDate.getDayOfMonth()));
            System.out.println("Seconds: " + secondsSince.getSeconds());
        } 
        else if (matcher.group(NUMBER_OF_YEAR) != null && matcher.group(NUMBER_OF_MONTH) != null) {
            YearMonth yearMonth = YearMonth.of(Integer.valueOf(matcher.group(NUMBER_OF_YEAR)).intValue(), Integer.valueOf(matcher.group(NUMBER_OF_MONTH)).intValue());
            secondsSince = Duration.between(zone, zone.minusYears(yearMonth.getYear()).minusMonths(yearMonth.getMonthValue()));
            System.out.println("Seconds: " + secondsSince.getSeconds());
        }       
        else if (matcher.group(NUMBER_OF_YEAR) != null) {
            Year year = Year.of(Integer.valueOf(matcher.group(NUMBER_OF_DAY)).intValue());
            secondsSince = Duration.between(zone, zone.minusYears(zone.getYear() - year.getValue()));
            System.out.println("Seconds: " + secondsSince.getSeconds());
        }
        else {
            System.out.println("Bad date");
        }
    }
    public void printHelp() {
        System.out.println("All commands \nwhenSunday = show when will be the nearest Sunday \nshowSecondsSince [enter date example: 1991 12 12] = show how much seconds elapsed from date \nchangeCity = changes city(timezone)");
        System.out.println("Add/delete = example + 5y 3m - add 5 years and 3 months \ny = years, m = months, d = day, h = hour, min = minute, s = second");
    }
    public void calculate(String number) { 
        Matcher matcher = INPUT_PATTERN_FOR_CALCULATE.matcher(number);
        matcher.find();
        boolean minusOperator = matcher.group(OPERATOR) == "-";
        boolean plusOperator = matcher.group(OPERATOR) == "+";
        if (matcher.group(YEARS) != null) {
            if (plusOperator) {
                zone = zone.plusYears(Integer.valueOf(matcher.group(YEARS)).longValue());
            }
            else if (minusOperator) {
                zone = zone.minusYears(Integer.valueOf(matcher.group(YEARS)).longValue());
            }
        }
        if (matcher.group(MONTHS) != null) {
            if (plusOperator) {
                zone = zone.plusMonths(Integer.valueOf(matcher.group(MONTHS)).longValue());
            }
            else if (minusOperator) {
                zone = zone.minusMonths(Integer.valueOf(matcher.group(MONTHS)).longValue());
            }
        }
        if (matcher.group(DAYS) != null) {
            if (plusOperator) {
                zone = zone.plusDays(Integer.valueOf(matcher.group(DAYS)).longValue());
            }
            else if (minusOperator) {
                zone = zone.minusDays(Integer.valueOf(matcher.group(DAYS)).longValue());
            }
        }
        if (matcher.group(HOURS) != null) {
            if (plusOperator) {
                zone = zone.plusHours(Integer.valueOf(matcher.group(HOURS)).longValue());   
            }
            else if (minusOperator) {
                zone = zone.minusHours(Integer.valueOf(matcher.group(HOURS)).longValue());
            }
        }
        if (matcher.group(MINUTES) != null) {
            if (plusOperator) {
                zone = zone.plusMinutes(Integer.valueOf(matcher.group(MINUTES)).longValue());    
            }
            else if (minusOperator) {
                zone = zone.minusMinutes(Integer.valueOf(matcher.group(MINUTES)).longValue());
            }
        }
        if (matcher.group(SECONDS) != null) {
            if (plusOperator) {
                zone = zone.plusSeconds(Integer.valueOf(matcher.group(SECONDS)).longValue());    
            }
            else if (minusOperator) {
                zone = zone.minusSeconds(Integer.valueOf(matcher.group(SECONDS)).longValue());
            }
        }
               
    }
}
