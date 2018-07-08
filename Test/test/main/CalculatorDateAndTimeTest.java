package main;
import org.junit.Before;
import org.junit.Test;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import static org.junit.Assert.assertEquals;

public class CalculatorDateAndTimeTest {

    private ZonedDateTime testDate;

    @Before
    public void resetDate() {
        testDate = ZonedDateTime.of(2018, 6, 26, 0, 0, 0, 0, ZoneId.of(TimeZone.getDefault().getID()));
    }

    @Test
    public void toStringTest() {
        String actual = CalculatorDateAndTime.toString(testDate);
        String expected = "2018-06-26";
        assertEquals(expected, actual);
    }

    @Test
    public void calculateAddYearMonthDay() {
        String actual = CalculatorDateAndTime.calculate(testDate, "+1y +1m +1d")
                .format(DateTimeFormatter.ISO_LOCAL_DATE);
        String expected = "2019-07-27";
        assertEquals("calculate add Year, Month, Day should change date", expected, actual);
    }

    @Test
    public void calculatorSubtractMonthsDays() {
        String actual = CalculatorDateAndTime.calculate(testDate, "-2m -2d").format(DateTimeFormatter.ISO_LOCAL_DATE);
        String expected = "2019-05-25";
        assertEquals("calculate subtract Months, Days should change date", expected, actual);
    }

    @Test
    public void calculatorSubtractDaysYears() {
        String actual = CalculatorDateAndTime.calculate(testDate, "-2d -2y").format(DateTimeFormatter.ISO_LOCAL_DATE);
        String expected = "2019-05-25";
        assertEquals("calculate subtract Days, Years should change date", expected, actual);
    }

    @Test
    public void calculatorAddSeveralDays() {
        String actual = CalculatorDateAndTime.calculate(testDate, "+1d +1d +1d +1d").format(DateTimeFormatter.ISO_LOCAL_DATE);
        String expected = "2019-05-25";
        assertEquals("bad command", expected, actual);
    }

    @Test
    public void calculatorAddDaysSubtractMonths() {
        String actual = CalculatorDateAndTime.calculate(testDate, "-2m +2d").format(DateTimeFormatter.ISO_LOCAL_DATE);
        String expected = "2019-05-25";
        assertEquals("add Days and subtract Months should change date", expected, actual);
    }

    @Test
    public void showSecondSince_YYYY_M_D_DASHES() {
        String input = "showSecondSince 2018-6-25";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "86400";
        assertEquals(expected, actual);
    }
    @Test
    public void showSecondSince_YYYY_MM_D_DASHES() {
        String input = "showSecondSince 2018-06-25";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "86400";
        assertEquals(expected, actual);
    }

    @Test
    public void showSecondsSince_YYYY_D_MM_SLASHES() {
        String input = "showSecondSince 2017/6/25";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "86400";
        assertEquals(expected, actual);
    }
    @Test
    public void showSecondsSince_YYYY_DD_MM_SLASHES() {
        String input = "showSecondSince 2017/06/25";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "86400";
        assertEquals(expected, actual);
    }

    @Test
    public void showSecondSince_MM_DD_YYYY_SLASHES() {
        String input = "showSecondSince 25/06/2018";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "86400";
        assertEquals(expected, actual);
    }
    @Test
    public void showSecondSince_MM_D_YYYY_SLASHES() {
        String input = "showSecondSince 1/1/2018";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "15120000";
        assertEquals(expected, actual);
    }

    @Test
    public void showSecondsSinceBadFormats() {
        String input = "showSecondSince 2/23/2017";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "Bad showSecondsSince date format";
        assertEquals(expected, actual);

        input = "dupa";
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "Bad Command";
        assertEquals(expected, actual);

        input = "showSecondsSince 903912";
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "Bad showSecondsSince date format";
        assertEquals(expected, actual);
    }
}
