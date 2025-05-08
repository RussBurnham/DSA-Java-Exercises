package dsa1;

import java.util.Set;
import java.util.HashSet;

public class FirstRepeatedCharacter {
    Set<Character> set = new HashSet<>();

    public char find(String string) {

        for (char c : string.toLowerCase().toCharArray()) {
            if (set.contains(c))
                return c; 
            set.add(c);
        }

        return '\0';
    }   
}
