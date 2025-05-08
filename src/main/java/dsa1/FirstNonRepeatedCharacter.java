package dsa1;

import java.util.Map;
import java.util.LinkedHashMap;

public class FirstNonRepeatedCharacter {
    Map<Character, Integer> map = new LinkedHashMap<>();
    
    public char findTheOne(String string) {
        for (char c : string.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }

        return '\0';
    }
}
