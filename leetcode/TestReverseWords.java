import java.util.*;

public class TestReverseWords {
    public String reverseWords(String s) {
        String retStr = new String();
        Stack<String> ss = new Stack<>();
        int startLoc = 0;
        int loc = s.indexOf(' ', startLoc);
        while (loc != -1) {
            ss.push(s.substring(startLoc, loc));
            startLoc = loc + 1;
            loc = s.indexOf(' ', startLoc);
        }
        ss.push(s.substring(startLoc));

        while (ss.isEmpty() == false) {
            retStr += ss.pop();
        }

        return retStr;
    }
}
