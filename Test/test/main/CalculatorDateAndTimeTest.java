package main;
import org.junit.Before;
import org.junit.Test;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimeZone;

import static org.junit.Assert.*;

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
    @Test // robic na metody :)
    public void calculate() {
        testDate = CalculatorDateAndTime.calculate(testDate, "+1y +1m +1d");
        String actual = testDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        String expected = "2019-07-27";
        assertEquals("calculate add should change date", expected, actual);

        testDate = CalculatorDateAndTime.calculate(testDate, "-2m -2d");
        actual = testDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        expected = "2019-05-25";
        assertEquals("calculate subtract should change date",expected, actual);

        testDate = CalculatorDateAndTime.calculate(testDate, "-2d -2y");
        actual = testDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        expected = "2019-05-25";
        assertEquals("calculate subtract should change date",expected, actual);

        testDate = CalculatorDateAndTime.calculate(testDate, "+1d +1d +1d +1d"); // nie dzialac :)
        actual = testDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        expected = "2019-05-25";
        assertEquals("bad command",expected, actual);

        testDate = CalculatorDateAndTime.calculate(testDate, "-2m +2d"); // dzialac
        actual = testDate.format(DateTimeFormatter.ISO_LOCAL_DATE);
        expected = "2019-05-25";
        assertEquals("add days and subtract months should change date",expected, actual);
    }
    @Test
    public void showSecondSince() {
        String input = "showSecondSince 2018-6-25";
        String actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        String expected = "86400";
        assertEquals(expected, actual);

        input = "showSecondSince 2018-06-25";
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "86400";
        assertEquals(expected, actual);

        input = "showSecondSince 2017/6/25";
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "86400";
        assertEquals(expected, actual);

        input = "showSecondSince 2017/06/25";
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "86400";
        assertEquals(expected, actual);

        input = "showSecondSince 25/06/2018";
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "86400";
        assertEquals(expected, actual);

        input = "showSecondSince 1/1/2018"; // dzialac
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "15120000";
        assertEquals(expected, actual);

        input = "showSecondSince 2/23/2017"; // nie dzialac
        actual = CalculatorDateAndTime.showSecondSince(testDate, input);
        expected = "Bad command";
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