import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindRepeatedSubString {
    public static List<String> findRepeated(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeat = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (!seen.add(sub)) {
                repeat.add(sub);
            }
        }
        return new ArrayList<String>(repeat);
    }
}
