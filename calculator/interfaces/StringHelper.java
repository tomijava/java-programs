package calculator.interfaces;

public class StringHelper {

    public static String removeWhitespace (String string) {
        return string.replaceAll("\\s","");
    }
}
