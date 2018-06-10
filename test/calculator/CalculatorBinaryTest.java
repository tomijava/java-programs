package calculator;

import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorBinaryTest {

    @Test
    public void getBinaryNumberAsDecimalOnlyOnes() {
        int expected = 7;
        int actual = CalculatorBinary.getBinaryStringAsInt("111");
        assertEquals(expected, actual);
    }

    @Test
    public void getBinaryNumberAsDecimalOnlyZeroes() {
        int expected = 0;
        int actual = CalculatorBinary.getBinaryStringAsInt("000");
        assertEquals(expected, actual);
    }

    @Test
    public void getBinaryNumberAsDecimalWrongInput() {
        int expected = 4;
        int actual = CalculatorBinary.getBinaryStringAsInt("dupa");
        assertEquals(expected, actual);
    }

    @Test
    public void getBinaryNumberAsDecimalNegativeInput() {
        int expected = -7;
        int actual = CalculatorBinary.getBinaryStringAsInt("-111");
        assertEquals(expected, actual);
    }

    @Test
    public void getBinaryNumberAsDecimalFour() {
        int expected = 4;
        int actual = CalculatorBinary.getBinaryStringAsInt("00100");
        assertEquals(expected, actual);
    }


    @Test
    public void calculate() {
        Calculator c = new CalculatorBinary();
        c.calculate("+01010");
        String actual = c.toString();
        String expected = "1010";

        assertEquals(expected, actual);
    }
}