import java.util.*;
import java.lang.*;

public class Strings {

    public static StringBuilder removeWhiteSpace (StringBuilder input) {

        for (int i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                input.deleteCharAt(i);
                i--;
            }
        }
        return input;
    }
}
