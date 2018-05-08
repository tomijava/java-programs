package calculator.interfaces;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.regex.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.time.DayOfWeek;
import java.time.Duration;
import java.time.Year;
import java.time.YearMonth;
import java.time.LocalDate;
public class CalculatorDateAndTime implements Calculator {

	private final Pattern pattern = Pattern.compile("^([\\+\\-])\\s*((\\d*)y)?\\s*((\\d*)m)?\\s*((\\d*)d)?\\s*((\\d*)h)?\\s*((\\d*)min)?\\s*((\\d*)s)?$");
	
	private ZonedDateTime zone = ZonedDateTime.now();

	public CalculatorDateAndTime (Zone zone) {
		this.zone = ZonedDateTime.now(ZoneId.of(zone.idZone));
	}
	public String toString () {
		return zone.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
    public String whenSunday () {
        return "Sunday is " + zone.with(TemporalAdjusters.next(DayOfWeek.SUNDAY)).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
    public void showSecondsSince (String input) {
        Pattern yearMonthDay = Pattern.compile("^showSecondsSince(\\d{1,4})\\s?([1-9]|1[0-2])?\\s?([1-9]|1[0-9]|2[0-9]|3[01])?$");
        Matcher matcher = yearMonthDay.matcher(input);
        Duration secondsSince;
        matcher.matches();

        if (matcher.group(2) != null && matcher.group(3) != null && matcher.group(1) != null) {
            LocalDate localDate = LocalDate.of(Integer.valueOf(matcher.group(1)).intValue(), Integer.valueOf(matcher.group(2)).intValue(), Integer.valueOf(matcher.group(3)).intValue());
            secondsSince =  Duration.between(zone, zone.minusYears(localDate.getYear()).minusMonths(localDate.getMonthValue()).minusDays(localDate.getDayOfMonth()));
            System.out.println("Seconds: " + secondsSince.getSeconds());
        } 
        else if (matcher.group(1) != null && matcher.group(2) != null) {
            YearMonth yearMonth = YearMonth.of(Integer.valueOf(matcher.group(1)).intValue(), Integer.valueOf(matcher.group(2)).intValue());
            secondsSince = Duration.between(zone, zone.minusYears(yearMonth.getYear()).minusMonths(yearMonth.getMonthValue()));
            System.out.println("Seconds: " + secondsSince.getSeconds());
        }       
        else if (matcher.group(1) != null) {
            Year year = Year.of(Integer.valueOf(matcher.group(1)).intValue());
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
	public void calculate (String number) { 
		Matcher matcher = pattern.matcher(number);
		if (matcher.find()) {
			if (matcher.group(1).equals("+")) {
				if(matcher.group(2) != null && matcher.group(3) != null) {
					if (Pattern.matches("\\d*y", matcher.group(2))) {
						zone = zone.plusYears(Integer.valueOf(matcher.group(3)).longValue());
					}
				}
				if(matcher.group(4) != null && matcher.group(5) != null) {
					if (Pattern.matches("\\d*m", matcher.group(4))) {
						zone = zone.plusMonths(Integer.valueOf(matcher.group(5)).longValue());
					}
				}
				if(matcher.group(6) != null && matcher.group(7) != null) {
					if (Pattern.matches("\\d*d", matcher.group(6))) {
						zone = zone.plusDays(Integer.valueOf(matcher.group(7)).longValue());
					}
				}
				if(matcher.group(8) != null && matcher.group(9) != null) {
					if (Pattern.matches("\\d*h", matcher.group(8))) {
						zone = zone.plusHours(Integer.valueOf(matcher.group(9)).longValue());
					}
				}
				if(matcher.group(10) != null && matcher.group(11) != null) {
					if (Pattern.matches("\\d*min", matcher.group(10))) {
						zone = zone.plusMinutes(Integer.valueOf(matcher.group(11)).longValue());
					}
				}
				if(matcher.group(12) != null && matcher.group(13) != null) {
					if (Pattern.matches("\\d*s", matcher.group(12))) {
						zone = zone.plusSeconds(Integer.valueOf(matcher.group(13)).longValue());
					}
				}
			}
			else if (matcher.group(1).equals("-")) {
				if(matcher.group(2) != null && matcher.group(3) != null) {
					if (Pattern.matches("\\d*y", matcher.group(2))) {
						zone = zone.minusYears(Integer.valueOf(matcher.group(3)).longValue());
					}
				}
				if(matcher.group(4) != null && matcher.group(5) != null) {
					if (Pattern.matches("\\d*m", matcher.group(4))) {
						zone = zone.minusMonths(Integer.valueOf(matcher.group(5)).longValue());
					}
				}
				if(matcher.group(6) != null && matcher.group(7) != null) {
					if (Pattern.matches("\\d*d", matcher.group(6))) {
						zone = zone.minusDays(Integer.valueOf(matcher.group(7)).longValue());
					}
				}
				if(matcher.group(8) != null && matcher.group(9) != null) {
					if (Pattern.matches("\\d*h", matcher.group(8))) {
						zone = zone.minusHours(Integer.valueOf(matcher.group(9)).longValue());
					}
				}
				if(matcher.group(10) != null && matcher.group(11) != null) {
					if (Pattern.matches("\\d*min", matcher.group(10))) {
						zone = zone.minusMinutes(Integer.valueOf(matcher.group(11)).longValue());
					}
				}
				if(matcher.group(12) != null && matcher.group(13) != null) {
					if (Pattern.matches("\\d*s", matcher.group(12))) {
						zone = zone.minusSeconds(Integer.valueOf(matcher.group(13)).longValue());
					}
				}
			}
		}		
	}
}
