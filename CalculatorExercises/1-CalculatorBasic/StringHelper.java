public class StringHelper {

    public static String removeWhitespace (String string) {
        String input = string.replaceAll("\\s",""); 
        return input;
    }
}
