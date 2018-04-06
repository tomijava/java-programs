import java.util.*;
import java.lang.*;

public class StringHelper {

    public static StringBuilder removeWhiteSpace (String string) {

    	StringBuilder input  = new StringBuilder(string);

        for (int i = 0; i < input.length(); i++) {
            if (Character.isWhitespace(input.charAt(i))) {
                input.deleteCharAt(i);
                i--;
            }
        }
        return input;
    }
}
